package models;

// This DAO class will provide access to our Model data
// but will not require accessing the ListBurgersDao or ListIngredientsDao
// directly -- Instead, we will reference those interfaces
public class DaoFactory {
	
	private static McBurgers mcBurgersDao; // the McBurgers interface
	
	public static McBurgers getMcBurgersDao() {
		if (mcBurgersDao == null) {
			mcBurgersDao = new ListBurgersDao();
		}
		return mcBurgersDao;
	}
	
	private static Ingredients ingredientsDao; // the Ingredients interface
	
	public static Ingredients getIngredientsDao() {
		if (ingredientsDao == null) {
			ingredientsDao = new ListIngredientsDao();
		}
		return ingredientsDao;
	}
}
