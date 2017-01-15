package br.feevale.model;

public class User
{
	private int id;
	private String username, name;
	private boolean admin;
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/*
	 * You should use the constructor approach, when you want to create a new instance of the object, with the values already populated(a ready to use object with value populated). This way you need not explicitly sit and call the setter methods for each field in the object to populate them.
	 * You set the value using a setter approach, when you want to change the value of a field, after the object has been created.	
	 */
	public String getUsername()
	{
		return username;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setADM(boolean admin)
	{
		this.admin = admin;
	}
	
	public boolean isADM()
	{
		return admin;
	}
}
