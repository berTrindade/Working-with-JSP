package br.feevale.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.model.Product;
import br.feevale.model.dao.ProductDAO;

@WebServlet("/ProductManager")
public class ProductManager extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException
	{
		// Sick stuff happening around here! Watch out! 
		ArrayList<Product> products = new ProductDAO().getList();

		request.setAttribute("arrayList", products);
		request.getRequestDispatcher("/br.feevale.view/listing.jsp").forward(request, response);
	}
}
