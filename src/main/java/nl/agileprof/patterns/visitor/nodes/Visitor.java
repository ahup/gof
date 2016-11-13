package nl.agileprof.patterns.visitor.nodes;

public interface Visitor
{
   void visitAddNode(AddNode n);
   void visitDivNode(DivNode n);
   void visitMulNode(MulNode n);
   void visitNegNode(NegNode n);
   void visitNumNode(NumNode n);
   void visitSubNode(SubNode n);
}