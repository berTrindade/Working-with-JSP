package br.feevale.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.feevale.model.Cart;
import br.feevale.model.Item;
import br.feevale.model.Product;
import br.feevale.utils.DBConnect;

public class CartDAO
{
	public Cart getLastOne()
	{
		Cart cart = null;
		
		try
		{
			ResultSet rs = DBConnect.executeQuery("SELECT * FROM cart ORDER BY id DESC LIMIT 1");
			
			if (rs.next())
			{
				cart = new Cart();
				cart.setId(rs.getInt("id"));
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return cart;
	}
	
	public ArrayList<Item> getList(int id)
	{
		ArrayList<Item> items = new ArrayList<Item>();
		
		try
		{
			ResultSet rs = DBConnect.executeQuery(""
					+ "SELECT i.id, p.name, p.unitaryPrice, i.quantity, i.total"
					+ "FROM item AS i"
					+ "INNER JOIN cart AS c ON i.cart_ID = c.id"
					+ "INNER JOIN product AS p ON i.product_ID = p.id"
					+ "WHERE c.id = '"+id+"'"
					+ "");
			
			while(rs.next())
			{
				Item item = new Item();

				item.setId(rs.getInt("id"));
				
				Product product = new ProductDAO().getProductByID(rs.getInt("product_ID"));
				item.setProdutc(product);
				
				item.setQuantity(rs.getInt("quantity"));
				item.setTotal(rs.getInt("total"));
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return items;
	}
	
	public boolean saved(Cart cart)
	{
		try
		{
			DBConnect.executeUpdate("INSERT INTO cart () VALUES ()");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean save(Item item)
	{
		try
		{
			DBConnect.executeUpdate("INSERT INTO item (cart_ID, product_ID, quantity, total) VALUES ('"+item.getCart().getId()+"', '"+item.getProduct().getId()+"', '"+item.getQuantity()+"', '"+item.getTotal()+"')");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
}
