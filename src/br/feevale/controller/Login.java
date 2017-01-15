package br.feevale.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.feevale.model.User;
import br.feevale.model.dao.UserDAO;

@WebServlet("/Login")
public class Login extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String message = null;
		
		User user = new UserDAO().authenticate(username, password);
		
		if(user != null) 
		{
			request.getSession().setAttribute("user", user);
			request.getRequestDispatcher("./br.feevale.view/index-v2.jsp").forward(request, response);
		} else
		{
			message = "Invalid username or password!";
			request.setAttribute("message", message);
			
			// Faz o forward para a pagina JSP
			request.getRequestDispatcher("./br.feevale.view/index.jsp").forward(request, response);
		}
	}
}
