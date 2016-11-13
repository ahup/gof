package nl.agileprof.patterns.visitor.listitems;

/**
 * @author ahup
 * @since 11/11/2016
 */
public class Fruit implements ItemElement
{
	private int pricePerKg;

	private int weight;

	private String name;

	public Fruit(int priceKg, int wt, String nm)
	{
		this.pricePerKg = priceKg;
		this.weight = wt;
		this.name = nm;
	}

	public int getPricePerKg()
	{
		return pricePerKg;
	}


	public int getWeight()
	{
		return weight;
	}

	public String getName()
	{
		return this.name;
	}

	public int accept(Visitor visitor)
	{
		return visitor.visit(this);
	}
}
