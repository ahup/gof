package nl.agileprof.patterns.visitor.nodes;
public interface ASTNode
{
   String getName();
   void accept(Visitor v);
}