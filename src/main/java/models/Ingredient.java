package models;

import java.io.Serializable;

public class Ingredient implements Serializable {
	// ****************** CLASS PROPERTIES ********************
	
	// id
	private long id;
	// title
	private String title;
	// quantity
	private int quantity;
	
	// ****************** CONSTRUCTOR ********************
	
	// zero-argument constructor, so Java can reserve space in memory,
	// before we even set the properties (with NO null-pointer exceptions)
	
	public Ingredient() {}
	
	// ****************** GETTERS AND SETTERS ********************
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
