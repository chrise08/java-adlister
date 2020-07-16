package models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListBurgersDao implements McBurgers {
	
	private List<McBurger> burgers = new ArrayList<>();
	
	public ListBurgersDao() {
		// use the ingredients we already made, and make some burgers
		
		// grab the ingredients
		Ingredient pickles = DaoFactory.getIngredientsDao().findById(1);
		Ingredient tomatoes = DaoFactory.getIngredientsDao().findById(2);
		Ingredient cheese = DaoFactory.getIngredientsDao().findById(3);
		Ingredient patty = DaoFactory.getIngredientsDao().findById(4);
		Ingredient bun = DaoFactory.getIngredientsDao().findById(5);
		
		ArrayList<Ingredient> bigMacIngredients = new ArrayList<>();
		
		McBurger bigMac = new McBurger();
		bigMac.setId(1);
		bigMac.setTitle("Big Mac");
		bigMac.setDescription("The big burger with secret special sauce.");
		bigMac.setPriceInCents(350);
		
		// Define what ingredients are in this burger
		bigMacIngredients.add(patty);
		bigMacIngredients.add(patty);
		bigMacIngredients.add(bun);
		bigMacIngredients.add(cheese);
		bigMacIngredients.add(pickles);
		bigMac.setIngredients(bigMacIngredients);
		burgers.add(bigMac);
		
		ArrayList<Ingredient> qpIngredients = new ArrayList<>();
		
		McBurger quarterPounder = new McBurger();
		quarterPounder.setId(2);
		quarterPounder.setTitle("Quarter Pounder");
		quarterPounder.setDescription("The classic go-to when you need protein.");
		quarterPounder.setPriceInCents(300);
		
		// Define what ingredients are in this burger
		qpIngredients.add(patty);
		qpIngredients.add(bun);
		qpIngredients.add(cheese);
		qpIngredients.add(pickles);
		quarterPounder.setIngredients(qpIngredients);
		burgers.add(quarterPounder);
		
		ArrayList<Ingredient> homestyleIngredients = new ArrayList<>();
		
		McBurger homestyle = new McBurger();
		homestyle.setId(3);
		homestyle.setTitle("Homestyle");
		homestyle.setDescription("The one that got away...");
		homestyle.setPriceInCents(250);
		
		// Define what ingredients are in this burger
		homestyleIngredients.add(patty);
		homestyleIngredients.add(bun);
		homestyleIngredients.add(pickles);
		homestyleIngredients.add(tomatoes);
		homestyle.setIngredients(homestyleIngredients);
		burgers.add(homestyle);
	}
	
	@Override
	public McBurger findById(long id) { // this is the 1-indexed ID (1,2,3) - need to subtract 1 to get 0-indexed
		// get the McBurger at the index 'id'
		// DB Representation (actual ID's) ---> [ '1' => bigMac, '2' => quarterPounder ... ]
		// the array list itself (0-indexed) ---> [ '0' => bigMac, '1' => quarterPounder ... ]
		return burgers.get((int)id - 1);
	}
	
	@Override
	public long createBurger(McBurger burger) {
		// we need to determine what the ID will be of this new burger
		burger.setId(burgers.size() + 1);
		
		// add this burger to the list in this Data Access Object (DAO)
		burgers.add(burger);
		
		// we need to return the ID of our newly created burger
		return burger.getId();
	}
}
