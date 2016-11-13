package nl.agileprof.patterns.builder;

/**
 * @author ahup
 * @since 13/11/2016
 */
// Director
public class MealDirector
{
	public Meal createMeal(MealBuilder builder)
	{
		builder.buildDrink();
		builder.buildMain();
		builder.buildDessert();
		return builder.getMeal();
	}
}
