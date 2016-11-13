package nl.agileprof.patterns.visitor.nodes;
import java.io.IOException;
import java.io.Reader;

public class Lexer
{
   private Reader reader;
   private Token curToken;
   private int lineNum;
   private int linePos;
   private StringBuilder sb;
   private int savedch;
   private boolean isNewLine;

   public Lexer(Reader reader)
   {
      this.reader = reader;
      curToken = null;
      lineNum = 1;
      linePos = 0;
      sb = new StringBuilder();
      savedch = -1;
      isNewLine = false;
   }

   public Token getCurrentToken()
   {
      return curToken;
   }

   public int getLineNum()
   {
      return lineNum;
   }

   public int getLinePos()
   {
      return linePos;
   }

   public Token getNextToken() throws IOException
   {
      int ch;

      if (isNewLine)
      {
         ++lineNum;
         linePos = 0;
         isNewLine = false;
      }

      // Skip whitespace.
      while ((ch = getChar()) == ' ' || ch == '\t');

      // Detect EOF.
      if (ch == -1)
         return curToken = new Token(TokenType.EOF, null);

      // Detect EOLN.
      if (ch == '\r')
      {
         --linePos; // Ignore carriage return.
         ch = getChar(); // Read newline.
      }
      if (ch == '\n')
      {
         isNewLine = true;
         return curToken = new Token(TokenType.EOLN, null);
      }

      // Detect number.
      if (Character.isDigit(((char) ch)))
      {
         sb.setLength(0);
         do
         {
            sb.append((char) ch);
            ch = getChar();
         }
         while (Character.isDigit(ch));
         if (ch == '.')
         {
            sb.append('.');
            while (Character.isDigit(ch = getChar()))
               sb.append((char) ch);
         }
         ungetChar(ch);
         return curToken = new Token(TokenType.NUM, sb.toString());
      }

      // Detect identifier.
      if (Character.isLetter((char) ch))
      {
         sb.setLength(0);
         do
         {
            sb.append((char) ch);
            ch = getChar();
         }
         while (Character.isLetterOrDigit(ch));
         ungetChar(ch);
         return curToken = new Token(TokenType.ID, sb.toString());
      }

      // Detect arithmetic symbol token.

      switch (ch)
      {
         case '+': return curToken = new Token(TokenType.ADD, "+");
         case '-': return curToken = new Token(TokenType.SUB, "-");
         case '*': return curToken = new Token(TokenType.MUL, "*");
         case '/': return curToken = new Token(TokenType.DIV, "/");
      }

      // Detect open or close parenthesis.

      if (ch == '(')
         return curToken = new Token(TokenType.OPENPAR, "(");
      if (ch == ')')
         return curToken = new Token(TokenType.CLOSEPAR, ")");

      // Detect any other character as a single-character token.
      return curToken = new Token(TokenType.OTHER, ((char) ch)+"");
   }

   private int getChar() throws IOException
   {
      ++linePos;
      if (savedch != -1)
      {
         int ch = savedch;
         savedch = -1;
         return ch;
      }
      return reader.read();
   }

   private void ungetChar(int ch)
   {
      savedch = ch;
      --linePos;
   }

   public enum TokenType
   {
      ADD, CLOSEPAR, DIV, EOF, EOLN, ID, MUL, NUM, OPENPAR, OTHER, SUB
   }

   public class Token
   {
      public TokenType type;
      public String lexeme;

      public Token(TokenType type, String lexeme)
      {
         this.type = type;
         this.lexeme = lexeme;
      }

      @Override
      public String toString()
      {
         return type.toString()+": "+lexeme;
      }
   }
}