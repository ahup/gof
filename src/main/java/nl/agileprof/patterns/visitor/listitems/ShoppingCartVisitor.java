package nl.agileprof.patterns.visitor.listitems;

import java.math.BigDecimal;

/**
 * @author ahup
 * @since 11/11/2016
 */
public class ShoppingCartVisitor implements Visitor
{
	private BigDecimal total = BigDecimal.ZERO;

	public int visit(Book book)
	{
		int cost = 0;
		//apply 5$ discount if book price is greater than 50
		if (book.getPrice() > 50)
		{
			cost = book.getPrice() - 5;
		}
		else
		{
			cost = book.getPrice();
		}
		System.out.println("Book ISBN::" + book.getIsbnNumber() + " cost =" + cost);
		return cost;
	}

	public int visit(Fruit fruit)
	{
		int cost = fruit.getPricePerKg() * fruit.getWeight();
		System.out.println(fruit.getName() + " cost = " + cost);
		return cost;
	}
}
