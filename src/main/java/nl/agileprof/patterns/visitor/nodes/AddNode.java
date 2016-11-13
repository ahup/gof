package nl.agileprof.patterns.visitor.nodes;
public class AddNode extends BinNode
{
   @Override
   public void accept(Visitor v)
   {
      v.visitAddNode(this);
   }

   @Override
   public String getName()
   {
      return "+";
   }
}