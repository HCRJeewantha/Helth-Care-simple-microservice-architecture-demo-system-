package com.controller;

import java.sql.*;
import java.util.*;
import com.java.Patient;

import com.config.dbconnector;

public class cntPatient {
	 
		
		Connection con = null;
		
		public cntPatient()
		{		 
			con = dbconnector.connector();
		} 
	
	public List<Patient>getPatients(){
	   	 
	   	 List<Patient> patients = new ArrayList<>();
	   	 String sql = "select * from Patient";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  Patient p = new Patient();
					  p.setPID(rs.getInt(1));
					  p.setLastName(rs.getString(2));
					  p.setFirstName(rs.getString(3));
					  p.setEmail(rs.getString(4));
					  p.setRole(rs.getString(5));
					  p.setStreetNo(rs.getString(6));
					  p.setCity(rs.getString(7));
					  p.setPostalcode(rs.getString(8));
					  p.setPassword(rs.getString(9));
					   
					  
					  patients.add(p);
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return patients;
	    }
	    
	    
	    
	    
	    
	    
	    
	    public Patient getPatient(int pid)
	    
	    {
	   	 String sql = "select * from Patient where PID="+pid;
	   	  Patient p = new Patient();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  p.setPID(rs.getInt(1));
					  p.setLastName(rs.getString(2));
					  p.setFirstName(rs.getString(3));
					  p.setEmail(rs.getString(4));
					  p.setRole(rs.getString(5));
					  p.setStreetNo(rs.getString(6));
					  p.setCity(rs.getString(7));
					  p.setPostalcode(rs.getString(8));
					  p.setPassword(rs.getString(9));
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return p;
	    }

		public void create(Patient p1) 
		{
			String sql = "insert into Patient values(?,?,?,?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, p1.getPID());
			  st.setString(2, p1.getLastName());
			  st.setString(3, p1.getFirstName());
			  st.setString(4, p1.getEmail());
			  st.setString(5, p1.getRole());
			  st.setString(6, p1.getStreetNo());
			  st.setString(7, p1.getCity());
			  st.setString(8, p1.getPostalcode());
			  st.setString(9, p1.getPassword());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		
		public void update(Patient p1) 
		{
			String sql = "update Patient set lastName=?,firstName=?,email=?,role=?,streetNo=?,city=?,postalcode=?,password=? where PID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setString(1, p1.getLastName());
			  st.setString(2, p1.getFirstName());
			  st.setString(3, p1.getEmail());
			  st.setString(4, p1.getRole());
			  st.setString(5, p1.getStreetNo());
			  st.setString(6, p1.getCity());
			  st.setString(7, p1.getPostalcode());
			  st.setString(8, p1.getPassword());
			  st.setInt(9, p1.getPID());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void delete(int pid) {

			String sql = "delete from Patient where PID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, pid);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}


}
