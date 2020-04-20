package com.controller;

import java.sql.*;
import java.util.*;

import com.java.Patient;
import com.java.Report;

import com.config.dbconnector;

public class cntReport {
	
	Connection con = null;
	
	public cntReport()
	{		 
		con = dbconnector.connector();
	} 

	
	public void create(Report r1) 
	{
		String sql = "insert into report values(?,?,?,?)";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, r1.getRID());
		  st.setString(2, r1.getDetails());
		  st.setInt(3, r1.getSessionID());
		  st.setInt(4, r1.getPatientID());

         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}

	

	
	public List<Report>getListReport(int sessionID){
	   	 
	   	 List<Report> report1 = new ArrayList<>();
	   	 String sql = "select * from Report where sessionID="+sessionID;
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  Report r = new Report();
					  r.setRID(rs.getInt(1));
					  r.setDetails(rs.getString(2));
					  r.setSessionID(rs.getInt(3));
					  r.setPatientID(rs.getInt(4));
					  				   
					  
					  report1.add(r);
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return report1;
	    }
	    
	   
	
public Report getReport(int rID)
    
    {
   	 String sql = "select * from Report where patientID="+rID;
   	  Report r = new Report();
   	 try 
   	   {
			  Statement st = con.createStatement();
			  ResultSet rs = st.executeQuery(sql);
			  if(rs.next())
			  {
				
				  r.setRID(rs.getInt(1));
				  r.setDetails(rs.getString(2));
				  r.setSessionID(rs.getInt(3));
				  r.setPatientID(rs.getInt(4));
				  				   
			  }
			
		    } 
   	 catch (Exception e) 
   	  {
			
		   System.out.println(e);
		  } 
   	 return r;
    }
	
	
	public void update(Report r1) 
	{
		String sql = "update Report set details=?,sessionID=?,patientID=? where RID=?";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);

		  st.setString(1, r1.getDetails());
		  st.setInt(2, r1.getSessionID());
		  st.setInt(3, r1.getPatientID());
		  st.setInt(4, r1.getRID());
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}



	public void delete(int rid) {

		String sql = "delete from Report where RID=?";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  st.setInt(1, rid);
         st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 

	}



	
}
