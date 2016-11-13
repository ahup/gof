package nl.agileprof.patterns.visitor.nodes;

public class SubNode extends BinNode
{
   @Override
   public void accept(Visitor v)
   {
      v.visitSubNode(this);
   }

   @Override
   public String getName()
   {
      return "-";
   }
}