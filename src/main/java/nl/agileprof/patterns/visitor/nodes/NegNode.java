package nl.agileprof.patterns.visitor.nodes;

public class NegNode extends UnNode
{
	@Override
	public void accept(Visitor v)
	{
		v.visitNegNode(this);
	}

	@Override
	public String getName()
	{
		return "-";
	}
}