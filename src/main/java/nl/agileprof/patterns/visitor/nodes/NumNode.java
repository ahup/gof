package nl.agileprof.patterns.visitor.nodes;

public class NumNode implements ASTNode
{
   public double value;

   @Override
   public void accept(Visitor v)
   {
      v.visitNumNode(this);
   }

   @Override
   public String getName()
   {
      return ""+value;
   }
}