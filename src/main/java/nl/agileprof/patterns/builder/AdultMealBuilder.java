package nl.agileprof.patterns.builder;

/**
 * @author ahup
 * @since 13/11/2016
 */
public class AdultMealBuilder extends MealBuilder
{
	public void buildDrink(){
		// add drinks to the meal
	}
	public void buildMain(){
		// add main part of the meal
	}
	public void buildDessert(){
		// add dessert part to the meal
	}
	public Meal getMeal(){return meal;}
}
