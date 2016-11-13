package nl.agileprof.patterns.visitor.nodes;

public class PrintVisitor implements Visitor
{
   private final static int TABSIZE = 4;

   private int depth;

   @Override
   public void visitAddNode(AddNode n)
   {
      depth++;
      n.left.accept(this);
      depth--;
      println(n.getName());
      depth++;
      n.right.accept(this);
      depth--;
   }

   @Override
   public void visitDivNode(DivNode n)
   {
      depth++;
      n.left.accept(this);
      depth--;
      println(n.getName());
      depth++;
      n.right.accept(this);
      depth--;
   }

   @Override
   public void visitMulNode(MulNode n)
   {
      depth++;
      n.left.accept(this);
      depth--;
      println(n.getName());
      depth++;
      n.right.accept(this);
      depth--;
   }

   @Override
   public void visitNegNode(NegNode n)
   {
      depth++;
      n.left.accept(this);
      depth--;
      println(n.getName());
   }

   @Override
   public void visitNumNode(NumNode n)
   {
      println(n.getName());
   }

   @Override
   public void visitSubNode(SubNode n)
   {
      depth++;
      n.left.accept(this);
      depth--;
      println(n.getName());
      depth++;
      n.right.accept(this);
      depth--;
   }

   private void println(String s)
   {
      int n = depth*TABSIZE;
      for (int i = 0; i < n; i++)
         System.out.print(' ');
      System.out.println(s);
   }
}