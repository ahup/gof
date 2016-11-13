package nl.agileprof.patterns.visitor.nodes;

public class MulNode extends BinNode
{
   @Override
   public void accept(Visitor v)
   {
      v.visitMulNode(this);
   }

   @Override
   public String getName()
   {
      return "*";
   }
}