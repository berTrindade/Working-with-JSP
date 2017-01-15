package br.feevale.model.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.feevale.model.User;
import br.feevale.utils.DBConnect;

public class UserDAO
{
	public User authenticate(String username, String password)
	{
		User user = null;
		password = getMD5(password);
		
		try
		{
			ResultSet rs = DBConnect.executeQuery("SELECT * FROM user WHERE username = '"+username+"' AND password = '"+password+"'");
			
			if (rs.next())
			{
				user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setName(rs.getString("name"));
				user.setADM(rs.getBoolean("administrator"));
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		}

		return user;
	}
	
    private static String getMD5(String password)
    {
        try  
        {
        	/*
        	 *  Create MessageDigest instance for MD5
        	 *  Get the hash's bytes
        	 */
            byte[] hash = MessageDigest.getInstance("MD5").digest(password.getBytes());
            
            /*
             * Converting a byte sequence into a positive integer
             * and returning a hex number(base 16)
             */
            return new BigInteger(1, hash).toString(16);
            
        }  catch(NoSuchAlgorithmException ns) 
        {
            ns.printStackTrace();
            
        }
        
		return password;
    }
}
