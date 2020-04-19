package com.vihanga.Appointment.Service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.vihanga.Appointment.Database.AppointmentDatabase;
import com.vihanga.Appointment.Model.Appointment;

public class AppointmentService {
	
	
	Connection con = AppointmentDatabase.connector();
	
	//Get Appointment List
	public List<Appointment>getAppointments(){
	   	 
	   	 List<Appointment> appointment = new ArrayList<>();
	   	 String sql = "select * from appointment";
	   	 try 
	   	   {
	   		 
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  
				  while(rs.next())
				  {
					  Appointment a = new Appointment();
					  a.setAID(rs.getInt(1));
					  a.setName(rs.getString(2));
					  a.setNic(rs.getString(3));
					  a.setPhone(rs.getString(4));
					  a.setEmail(rs.getString(5));
					  a.setReportID(rs.getInt(6));
					  a.setSessionID(rs.getInt(7));
					  a.setPatientID(rs.getInt(8));
					  
					   			  
					  appointment.add(a);
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
	   	  }
	   	  
	   	 return appointment;
	   	 
	    }
	    
	    
	    
	    
	    
	    
	    //Get Only One Appointment
	    public Appointment getAppointment(int aid)
	    
	    {
	   	 String sql = "select * from appointment where AID="+aid;
	   	  Appointment a = new Appointment();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  a.setAID(rs.getInt(1));
					  a.setName(rs.getString(2));
					  a.setNic(rs.getString(3));
					  a.setPhone(rs.getString(4));
					  a.setEmail(rs.getString(5));
					  a.setReportID(rs.getInt(6));
					  a.setSessionID(rs.getInt(7));
					  a.setPatientID(rs.getInt(8));
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
	   	  } 
	   	 
	   	 return a;
	   	 
	    }
	    
	  //Get Patient search patient id
	    public Appointment getPatientID(int patientid)
	    
	    {
	    	List<Appointment> appointment = new ArrayList<>();
	   	 	String sql = "select * from appointment where patientID ="+patientid;
	   	 	Appointment a = new Appointment();
	   	 	
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  a.setAID(rs.getInt(1));
					  a.setName(rs.getString(2));
					  a.setNic(rs.getString(3));
					  a.setPhone(rs.getString(4));
					  a.setEmail(rs.getString(5));
					  a.setReportID(rs.getInt(6));
					  a.setSessionID(rs.getInt(7));
					  a.setPatientID(rs.getInt(8));
					 
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
	   	  } 
	   	 
	   	 return a;
	   	 
	    }


	    
	    //Create Appointment
		public void createAppointment(Appointment a1) 
		{
			String sql = "insert into appointment values(?,?,?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, a1.getAID());
			  st.setString(2, a1.getName());
			  st.setString(3, a1.getNic());
			  st.setString(4, a1.getPhone());
			  st.setString(5, a1.getEmail());
			  st.setInt(6, a1.getReportID());
			  st.setInt(7, a1.getSessionID());
			  st.setInt(8, a1.getPatientID());
			  
			  st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		//Update Appointment
		public void updateAppointment(Appointment a1) 
		{
			String sql = "update appointment set name=?,nic=?,phone=?,email=?,reportID=?,sessionID=?,patientID=? where AID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setInt(8, a1.getAID());
			  st.setString(1, a1.getName());
			  st.setString(2, a1.getNic());
			  st.setString(3, a1.getPhone());
			  st.setString(4, a1.getEmail());
			  st.setInt(5, a1.getReportID());
			  st.setInt(6, a1.getSessionID());
			  st.setInt(7, a1.getPatientID());
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void deleteAppointment(int aid) {

			String sql = "delete from appointment where AID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, aid);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}


}
