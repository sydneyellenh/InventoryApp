package org.elevenfifty.java301.sandwich;

import java.util.ArrayList;
import java.util.List;



public class Sandwich {

	public static enum BreadType {WHEAT, WHITE};
	
	private BreadType breadType;
	
	private List<Ingredient> ingredients;

	public Sandwich(BreadType breadType) {
		this.breadType = breadType;
		ingredients = new ArrayList<Ingredient>();
	}
	  

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sandwich [ingredients=");
		builder.append(ingredients);
		builder.append("]");
		return builder.toString();
	}


	public BreadType getBreadType() {
		return breadType;
	}
	
	public void addIngredient(Ingredient i) {
		this.ingredients.add(i);
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}	
	
	
	
}
