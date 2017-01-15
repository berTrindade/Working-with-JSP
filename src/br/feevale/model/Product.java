package br.feevale.model;

public class Product 
{
	private int id;
	private String name;
	private float unitaryPrice;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public float getUnitaryPrice()
	{
		return unitaryPrice;
	}
	
	public void setUnitaryPrice(float unitaryPrice)
	{
		this.unitaryPrice = unitaryPrice;
	}
}
