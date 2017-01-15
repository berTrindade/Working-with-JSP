package br.feevale.model;

import java.text.DecimalFormat;
import java.util.Locale;

public class Item
{
	private int id, quantity;
	private Product product;
	private Cart cart;
	private float total;
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public Product getProduct()
	{
		return product;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public void setProdutc(Product product)
	{
		this.product = product;
	}
	
	public Cart getCart()
	{
		return cart;
	}
	
	public void setCart(Cart cart)
	{
		this.cart = cart;
	}
	
	public float getTotal()
	{
		total = product.getUnitaryPrice() * quantity;
		return formatter(total);
	}
	
	public void setTotal(int total)
	{
		this.total = total;
	}
	
	private float formatter(float value)
	{
		Locale.setDefault(new Locale("en", "US"));
		
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		return Float.valueOf(decimalFormat.format(value));
	}
}

