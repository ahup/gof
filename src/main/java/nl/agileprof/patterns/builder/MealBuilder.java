package nl.agileprof.patterns.builder;

/**
 * @author ahup
 * @since 13/11/2016
 */
// Builder
public abstract class MealBuilder
{
	protected Meal meal = new Meal();

	public abstract void buildDrink();

	public abstract void buildMain();

	public abstract void buildDessert();

	public abstract Meal getMeal();
}
