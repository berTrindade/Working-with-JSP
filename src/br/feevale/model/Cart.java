package br.feevale.model;

import java.util.ArrayList;

public class Cart
{
	// Instance variable
	private int id;
	private ArrayList<Item> items;
	
	// Association
	private User user;
	private float total;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public ArrayList<Item> getItems()
	{
		return items;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public User getUser()
	{
		return user;
	}
	
	public float getTotal()
	{
		return total;
	}
	
	// Add item to Shopping Cart
	public void add(Item item)
	{
		// If Shopping Cart doesn't exist, a new one is created
		if(items == null)
			items = new ArrayList<Item>();
		
		items.add(item);
	}
}