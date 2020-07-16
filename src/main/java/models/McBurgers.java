package models;

public interface McBurgers {
	
	// This interface lists the methods that any class who implements
	// it, MUST define (or have these methods)
	McBurger findById(long id);
	
	// if we create a burger, return the ID of the newly created burger
	// so we can do stuff with it
	long createBurger(McBurger burger);
}
