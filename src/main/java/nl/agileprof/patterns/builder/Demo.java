package nl.agileprof.patterns.builder;

/**
 * @author ahup
 * @since 13/11/2016
 */
public class Demo
{
	public static void main(String[] args) {
		boolean isKid = Boolean.valueOf(args[0]);
		MealDirector director = new MealDirector();
		MealBuilder builder = null;
		if (isKid) {
			builder = new KidsMealBuilder();
		}
		else{
			builder = new AdultMealBuilder();
		}
		Meal meal = director.createMeal(builder);
	}
}
