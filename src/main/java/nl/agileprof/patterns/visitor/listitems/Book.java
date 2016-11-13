package nl.agileprof.patterns.visitor.listitems;

/**
 * @author ahup
 * @since 11/11/2016
 */
public class Book implements ItemElement
{
	private int price;

	private String isbnNumber;

	public Book(int cost, String isbn)
	{
		this.price = cost;
		this.isbnNumber = isbn;
	}

	public int getPrice()
	{
		return price;
	}

	public String getIsbnNumber()
	{
		return isbnNumber;
	}

	public int accept(Visitor visitor)
	{
		return visitor.visit(this);
	}
}
