package com.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.doctor;
import com.java.hospital;

import config.dbconnector;

public class cntDoctor {
	
	Connection con = null;
	
	public cntDoctor()
	{		 
		con = dbconnector.connecter();
	} 
	
	
	public void create(doctor d1) 
	{
		String sql = "insert into doctor values(?,?,?,?,?,?,?,?)";
  	 try 
	   {
		  PreparedStatement st = con.prepareStatement(sql);
		  
		  st.setInt(1, d1.getDID());
		  st.setString(2, d1.getLastName());
		  st.setString(3, d1.getFirstName());
		  st.setString(4, d1.getEmail());
		  st.setString(5, d1.getRole());
		  st.setString(6, d1.getDocID());
		  st.setString(7, d1.getPassword());
		  st.setString(8, d1.getSpecialization());
          st.executeUpdate();
	
		
	    } 
	 catch (Exception e) 
	  {
		
	   System.out.println(e);
	  } 
		
	}
	
	//get all doctors details when his/her hospital id entered
	public List<doctor> getAllDocInHospital(int hid)
	{
		 List<doctor> doctors = new ArrayList<>();
		String sql = "SELECT doctor.DID, doctor.LastName, doctor.FirstName, doctor.specialization\r\n" + 
				"FROM hospital\r\n" + 
				"INNER JOIN hospital_doctor\r\n" + 
				"ON hospital.HID = hospital_doctor.HID\r\n" + 
				"INNER JOIN doctor\r\n" + 
				"ON hospital_doctor.DID = doctor.DID\r\n" + 
				"WHERE hospital.HID ="+hid;
		
		   	 try 
		   	   {
					  Statement st = con.createStatement();
					  ResultSet rs = st.executeQuery(sql);
					  while(rs.next())
					  {
						  doctor d = new doctor();
						  d.setDID(rs.getInt(1));
						  d.setLastName(rs.getNString(2));
						  d.setFirstName(rs.getNString(3));
						  d.setSpecialization(rs.getString(4));
						  
						  doctors.add(d);
						
					  }
					
				    } 
		   	 catch (Exception e) 
		   	  {
					
				   System.out.println(e);
				  } 
		   	 return doctors;
		
	}
	
	public List<hospital> getAllHosInDoctor(int did)
	{
		 List<hospital> hospitals = new ArrayList<>();
		String sql = "SELECT hospital.HID,hospital.Name,hospital.StreetNo,hospital.City\r\n" + 
				"FROM doctor\r\n" + 
				"INNER JOIN hospital_doctor\r\n" + 
				"ON doctor.DID = hospital_doctor.DID\r\n" + 
				"INNER JOIN hospital\r\n" + 
				"ON hospital_doctor.HID = hospital.HID\r\n" + 
				"WHERE doctor.DID ="+did;
		
		   	 try 
		   	   {
					  Statement st = con.createStatement();
					  ResultSet rs = st.executeQuery(sql);
					  while(rs.next())
					  {
						  hospital h = new hospital();
						  h.setHID(rs.getInt(1));
						  h.setName(rs.getNString(2));
						  h.setStreetNo(rs.getNString(3));
						  h.setCity(rs.getString(4));
						  
						  hospitals.add(h);
						
					  }
					
				    } 
		   	 catch (Exception e) 
		   	  {
					
				   System.out.println(e);
				  } 
		   	 return hospitals;
		
	}

	 public doctor getDoctor(int did)
	    
	    {
	   	 String sql = "select * from Doctor where DID="+did;
	   	doctor d = new doctor();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  d.setDID(rs.getInt(1));
					  d.setLastName(rs.getString(2));
					  d.setFirstName(rs.getString(3));
					  d.setEmail(rs.getString(4));
					  d.setRole(rs.getString(5));
					  d.setDocID(rs.getString(6));
					  d.setPassword(rs.getString(7));
					  d.setSpecialization(rs.getString(8));
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return d;
	    }
	 
	 
	 public void updateDoctor(doctor d1) 
		{
			String sql = "update Doctor set lastName=?,firstName=?,email=?,role=?,docID=?,password=?,specialization=? where DID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setInt(1, d1.getDID());
			  st.setString(2, d1.getLastName());
			  st.setString(3, d1.getFirstName());
			  st.setString(4, d1.getEmail());
			  st.setString(5, d1.getRole());
			  st.setString(6, d1.getDocID());
			  st.setString(7, d1.getPassword());
			  st.setString(8, d1.getSpecialization());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
	 

		public void deleteDoc(int did) {

			String sql = "delete from Doctor where DID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, did);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}
	    
	
}



	


