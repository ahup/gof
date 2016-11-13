package nl.agileprof.patterns.visitor.nodes;

import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;

public class Parser
{
   private Lexer lexer;

   public ASTNode parse(String text) throws ParseException
   {
      try
      {
         lexer = new Lexer(new StringReader(text));
         lexer.getNextToken();
         return expr();
      }
      catch (IOException ioe)
      {
         // should not happen from a string-based reader
         return null;
      }
   }

   private ASTNode expr() throws IOException, ParseException
   {
      return expr1(term());
   }

   private ASTNode expr1(ASTNode n) throws IOException, ParseException
   {
      if (lexer.getCurrentToken().type == Lexer.TokenType.ADD)
      {
         lexer.getNextToken();
         return expr1(mkAddNode(n, term()));
      }
      else
      if (lexer.getCurrentToken().type == Lexer.TokenType.SUB)
      {
         lexer.getNextToken();
         return expr1(mkSubNode(n, term()));
      }
      else
      if (lexer.getCurrentToken().type == Lexer.TokenType.EOLN ||
          lexer.getCurrentToken().type == Lexer.TokenType.EOF ||
          lexer.getCurrentToken().type == Lexer.TokenType.CLOSEPAR)
         return n;
      else
         throw new ParseException("unexpected token '"+
                                  lexer.getCurrentToken().lexeme+"' "+
                                  "at position "+(lexer.getLinePos()-1),
                                  lexer.getLinePos()-1);
   }

   private ASTNode term() throws IOException, ParseException
   {
      return term1(factor());
   }

   private ASTNode term1(ASTNode n) throws IOException, ParseException
   {
      if (lexer.getCurrentToken().type == Lexer.TokenType.MUL)
      {
         lexer.getNextToken();
         return term1(mkMulNode(n, factor()));
      }
      else
      if (lexer.getCurrentToken().type == Lexer.TokenType.DIV)
      {
         lexer.getNextToken();
         return term1(mkDivNode(n, factor()));
      }
      else
         return n;
   }

   private ASTNode factor() throws IOException, ParseException
   {
      if (lexer.getCurrentToken().type == Lexer.TokenType.NUM)
      {
         double value = Double.parseDouble(lexer.getCurrentToken().lexeme);
         lexer.getNextToken();
         return mkNumNode(value);
      }
      else
      if (lexer.getCurrentToken().type == Lexer.TokenType.SUB)
      {
         lexer.getNextToken();
         return mkNegNode(factor());
      }
      else
      if (lexer.getCurrentToken().type == Lexer.TokenType.OPENPAR)
      {
         lexer.getNextToken();
         ASTNode temp = expr();
         if (lexer.getCurrentToken().type != Lexer.TokenType.CLOSEPAR)
            throw new ParseException("close parenthesis expected at position "+
                                     (lexer.getLinePos()-1),
                                     lexer.getLinePos()-1);
         else
            lexer.getNextToken();
         return temp;
      }
      else
         throw new ParseException("unexpected token '"+
                                  lexer.getCurrentToken().lexeme+"' "+
                                  "at position "+(lexer.getLinePos()-1),
                                  lexer.getLinePos()-1);
   }

   private ASTNode mkAddNode(ASTNode left, ASTNode right)
   {
      AddNode n = new AddNode();
      n.left = left;
      n.right = right;
      return n;
   }

   private ASTNode mkDivNode(ASTNode left, ASTNode right)
   {
      DivNode n = new DivNode();
      n.left = left;
      n.right = right;
      return n;
   }

   private ASTNode mkMulNode(ASTNode left, ASTNode right)
   {
      MulNode n = new MulNode();
      n.left = left;
      n.right = right;
      return n;
   }

   private ASTNode mkNegNode(ASTNode left)
   {
      NegNode n = new NegNode();
      n.left = left;
      return n;
   }

   private ASTNode mkNumNode(double value)
   {
      NumNode n = new NumNode();
      n.value = value;
      return n;
   }

   private ASTNode mkSubNode(ASTNode left, ASTNode right)
   {
      SubNode n = new SubNode();
      n.left = left;
      n.right = right;
      return n;
   }
}