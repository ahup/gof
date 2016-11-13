package nl.agileprof.patterns.visitor.nodes;

public class DivNode extends BinNode
{
   @Override
   public void accept(Visitor v)
   {
      v.visitDivNode(this);
   }

   @Override
   public String getName()
   {
      return "/";
   }
}