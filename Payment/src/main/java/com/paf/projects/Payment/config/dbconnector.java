package com.paf.projects.Payment.config;

import java.sql.*;

public class dbconnector {
	
	public static Connection connector()
	{
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/helth_care";
		String username = "root";
		String password = "";
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection Top");
			//con =  (Connection) DriverManager.getConnection(url,username,password);
			con = DriverManager.getConnection(url,username,password);
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
