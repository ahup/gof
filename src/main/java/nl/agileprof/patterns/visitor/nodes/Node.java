package nl.agileprof.patterns.visitor.nodes;
public interface Node
{
   boolean accept(Visitor v);
   String getName();
}
