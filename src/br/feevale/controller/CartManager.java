package br.feevale.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.model.Cart;
import br.feevale.model.Item;
import br.feevale.model.Product;
import br.feevale.model.User;
import br.feevale.model.dao.CartDAO;
import br.feevale.model.dao.ProductDAO;
import br.feevale.utils.DBConnect;

@WebServlet("/CartManager")
public class CartManager extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException
	{

		String action = request.getParameter("action");
		
		if (action.equals("add"))
		{
			// Retrives checkboxes values
			String[] checkboxes = request.getParameterValues("fruit");

			// Converting String array into a int array
			int[] id = new int[checkboxes.length];
			
			for (int i = 0; i < checkboxes.length; i++)
				id[i] = Integer.parseInt(checkboxes[i]);
			
			// Controle flag for insertion of new products
			boolean exists = false;
			
			/*
			 * Retrieves a Cart from session,
			 * if it doesn't exist in session the value will null
			 */
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			
			// Check if the Cart already existed
			if (cart == null)
			{
				User user = (User) request.getSession().getAttribute("user");
				
				try
				{
					DBConnect.executeUpdate("INSERT INTO cart (user_ID) VALUES ('"+user.getId()+"')");
				} catch (SQLException e)
				{
					e.printStackTrace();
				}

				cart = new CartDAO().getLastOne();
				request.getSession().setAttribute("cart", cart);
			}
			
			// Checking if there are items in the Cart
			if (cart.getItems() != null)
			{
				for (int i = 0; i < id.length; i++)
				{
					exists = false;
					
					for (Item item : cart.getItems())
					{
						if(item.getProduct().getId() == id[i])
						{
							// Increase item quantity
							item.setQuantity(item.getQuantity() + 1);
							
							exists = true;
							break;
						} 
					}

					// If the Item doens't exist, creates a new one 
					if (exists == false)
					{
						// Search for a product in the Database
						Product product = new ProductDAO().getProductByID(id[i]);
						
						// Create a new Item
						Item item = new Item();
						
						item.setId(cart.getItems().size() + 1);
						item.setProdutc(product);
						item.setQuantity(1);
						
						// Add a new Item
						cart.add(item);
					}
				}
			} else
			{
				for (int i = 0; i < id.length; i++)
				{
					Product product = new ProductDAO().getProductByID(id[i]);
					
					Item item = new Item();

					item.setId(i + 1);
					item.setProdutc(product);
					item.setQuantity(1);

					cart.add(item);
				}
			}
		
		} else if (action.equals("payment")) 
		{
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			
			if (cart.getItems() != null)
			{
				for (Item item : cart.getItems())
				{
					try
					{
				 		DBConnect.executeUpdate(""
				 				+ "INSERT INTO item (cart_ID, product_ID, quantity, total) "
				 				+ "VALUES ('"+cart.getId()+"', '"+item.getProduct().getId()+"', '"+item.getQuantity()+"', '"+item.getTotal()+"')");
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/DisplayShoppingCart");
	}
}