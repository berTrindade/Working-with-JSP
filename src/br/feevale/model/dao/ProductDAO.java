package br.feevale.model.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.feevale.model.Product;
import br.feevale.utils.DBConnect;

public class ProductDAO
{
	public ArrayList<Product> getList()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		
		try
		{
			ResultSet rs = DBConnect.executeQuery("SELECT * FROM product");
			
			while (rs.next())
			{
				Product product = new Product();
				
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setUnitaryPrice(rs.getFloat("unitaryPrice"));
				
				products.add(product);
			}
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return products;
	}
	
	public Product getProductByID(int id)
	{
		Product product = new Product();
		
		try
		{
			ResultSet rs = DBConnect.executeQuery("SELECT * FROM product WHERE id = " + id);
			
			/**
			 * A ResultSet cursor is initially positioned before the first row. 
			 * The first call to the method next makes the first row the current row.
			 */
			
			// Returns true if the new current row is valid
			if (rs.next())
			{
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setUnitaryPrice(rs.getFloat("unitaryPrice"));
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return product;
	}
}
