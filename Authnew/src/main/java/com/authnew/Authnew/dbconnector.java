package com.authnew.Authnew;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnector {
	
	public static  Connection connecter()
	{
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/helth_care";
		String username = "root";
		String password = "";
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			//con =  DriverManager.getConnection(url,username,password);
			con = DriverManager.getConnection("jdbc:mysql://localhost/helth_care?user="+username+"&password="+password);
			System.out.println("Connection Done");
			if (con != null) {
                System.out.println("Connected to the fail");
            }
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	} 
	

}