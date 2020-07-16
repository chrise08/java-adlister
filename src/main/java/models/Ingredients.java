package models;

public interface Ingredients {
	// This interface lists the methods that any class
	// who implements it, MUST define (or have these methods)
	Ingredient findById(long id);
	
	// if we create an ingredient, return the ID of the
	// newly created ingredient so we can do stuff with it
	long createIngredient(Ingredient ingredient);
}
