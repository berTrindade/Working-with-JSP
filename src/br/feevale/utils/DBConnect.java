package br.feevale.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect
{
	// JDBC driver name
	private static String jdbcDriver = "com.mysql.jdbc.Driver";
	
	// Database extra information
	private static String dataBaseConnection = "localhost";
	private static String dataBaseName = "shoppingCart";
	
	// Database credentials
	private static String username = "root";
	private static String password = "root";
	
	private static Connection connection = null;
	
	/*
	 * Open connection with the Database
	 */
	private static void openConnection()
	{
		try
		{
			// Register JDBC driver that will be used
			Class.forName(jdbcDriver).newInstance();
			
			/**
			 * host:port is the host name and port number of the computer hosting your database. 
			 * If not specified, the default values of host and port are 127.0.0.1 and 3306, respectively.
			 */
			connection = DriverManager.getConnection("jdbc:mysql://" + dataBaseConnection + "/" + dataBaseName + "?useSSL=false", username, password);
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	// Close Database connection
	public static Connection closeConnection()
	{
		try
		{
			connection.close();
			connection.clearWarnings();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return connection;
	}
	
	// Database Connection manager 
	public static Connection getConnection()
	{
		if (connection == null)
			openConnection();
		else
		{
			try
			{
				if (connection.isClosed())
					openConnection();
			} catch (SQLException e)
			{
				e.printStackTrace();
				openConnection();
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	
	// Check connection
	public static boolean isConnected()
	{
		if (connection == null)
			return false;
		try
		{
			return !(connection.isClosed());
		} catch (SQLException e)
		{
			return false;
		}
	}
	
	/**
	 * Interfaces Statement, 
	 * Connection and the ResultSet are finally implemented by 
	 * the third party JDBC Driver provider(MySQL).
	 */
		
	// This method is used for SQL statements which retrieve some data from the database. For example is SELECT statement.
	public static ResultSet executeQuery(String sqlStatement) throws SQLException
	{
		ResultSet rs = getConnection().createStatement().executeQuery(sqlStatement);
		return rs;
	}
	
	// This method is used for SQL statements which update the database in some way. For example INSERT, UPDATE and DELETE statements. 
	public static int executeUpdate(String sqlStatement) throws SQLException
	{
		int affectedRows = getConnection().createStatement().executeUpdate(sqlStatement);
		return affectedRows;
	}
}
