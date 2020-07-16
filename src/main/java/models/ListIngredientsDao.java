package models;

import java.util.ArrayList;
import java.util.List;

public class ListIngredientsDao implements Ingredients{
	
	private List<Ingredient> ingredients = new ArrayList<>();
	
	public ListIngredientsDao() {
		// pickles (x3)
		Ingredient pickles = new Ingredient();
		pickles.setId(1);
		pickles.setTitle("Pickles (x3)");
		pickles.setQuantity(3);
		ingredients.add(pickles);
		
		// tomatoes (x2)
		Ingredient tomatoes = new Ingredient();
		tomatoes.setId(2);
		tomatoes.setTitle("Tomatoes (x2)");
		tomatoes.setQuantity(2);
		ingredients.add(tomatoes);
		
		// cheese (x1)
		Ingredient cheese = new Ingredient();
		cheese.setId(3);
		cheese.setTitle("Cheese (x1)");
		cheese.setQuantity(1);
		ingredients.add(cheese);
		
		// patty (x1)
		Ingredient patty = new Ingredient();
		patty.setId(4);
		patty.setTitle("Patty (x1)");
		patty.setQuantity(1);
		ingredients.add(patty);
		
		// bun (x2)
		Ingredient bun = new Ingredient();
		bun.setId(5);
		bun.setTitle("Bun (x2)");
		bun.setQuantity(2);
		ingredients.add(bun);
	}
	
	@Override
	public Ingredient findById(long id) {
		// get the Ingredient at the index 'id'
		// DB Representation (actual ID's) ---> [ '1' => tomato, '2' => pickles ... ]
		// the array list itself (0-indexed) ---> [ '0' => tomato, '1' => pickles ... ]
		return ingredients.get((int)id - 1);
	}
	
	@Override
	public long createIngredient(Ingredient ingredient) {
		// we need to determine what the ID will be of this new ingredient
		ingredient.setId(ingredients.size() + 1);
		
		// add this ingredient to the list in this Data Access Object (DAO)
		ingredients.add(ingredient);
		
		// we need to return the ID of our newly created ingredient
		return ingredient.getId();
	}
}
