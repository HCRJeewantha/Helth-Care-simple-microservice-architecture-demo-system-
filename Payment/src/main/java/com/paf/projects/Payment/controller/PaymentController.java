package com.paf.projects.Payment.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.paf.projects.Payment.config.dbconnector;
import com.paf.projects.Payment.model.Payment;


public class PaymentController {
	 
		Connection con = dbconnector.connector();
	
	
	public List<Payment>getPayment(){
	   	 
	   	 List<Payment> payments = new ArrayList<>();
	   	 String sql = "select * from payment";
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  while(rs.next())
				  {
					  Payment p = new Payment();
					  p.setPayID(rs.getInt(1));
					  p.setCardName(rs.getString(2));
					  p.setCardNo (rs.getInt(3));
					  p.setZipCode (rs.getInt(4));
					  p.setSecCode (rs.getString(5));
					  p.setHospitalID (rs.getInt(6));
					  p.setPatientID(rs.getInt(7));
					  p.setAID(rs.getInt(8));
					  
					 
					  
					   
					  
					  payments.add(p);
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  }
	   	  
	   	 return payments;
	    }
	    
	    
	    
	    
	    
	    
	    
	    public Payment getPayment(int payid)
	    
	    {
	   	 String sql = "select * from payment where PayID="+payid;
	   	Payment p = new Payment();
	   	 try 
	   	   {
				  Statement st = con.createStatement();
				  ResultSet rs = st.executeQuery(sql);
				  if(rs.next())
				  {
					
					  p.setPayID(rs.getInt(1));
					  p.setCardName(rs.getString(2));
					  p.setCardNo (rs.getInt(3));
					  p.setZipCode (rs.getInt(4));
					  p.setSecCode (rs.getString(5));
					  p.setHospitalID (rs.getInt(6));
					  p.setPatientID(rs.getInt(7));
					  p.setAID(rs.getInt(8));
					 
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return p;
	    }
	    
	    
	    public Payment getPaymentA(int aid)
	    
	    {
	   	 String sql = "select * from payment where AID="+aid;
	   	Payment p1 = new Payment();
	   	 try 
	   	   {
				  Statement st1 = con.createStatement();
				  ResultSet rs1 = st1.executeQuery(sql);
				  if(rs1.next())
				  {
					
					  p1.setPayID(rs1.getInt(1));
					  p1.setCardName(rs1.getString(2));
					  p1.setCardNo (rs1.getInt(3));
					  p1.setZipCode (rs1.getInt(4));
					  p1.setSecCode (rs1.getString(5));
					  p1.setHospitalID (rs1.getInt(6));
					  p1.setPatientID(rs1.getInt(7));
					  p1.setAID(rs1.getInt(8));
					 
				  }
				
			    } 
	   	 catch (Exception e) 
	   	  {
				
			   System.out.println(e);
			  } 
	   	 return p1;
	    }

		
	    public void create(Payment p1) 
		{
			String sql = "insert into payment values(?,?,?,?,?,?,?,?)";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, p1.getPayID ());
			  st.setString(2, p1.getCardName ());
			  st.setInt(3, p1.getCardNo ());
			  st.setInt(4, p1.getZipCode ());
			  st.setString(5, p1.getSecCode ());
			  st.setInt(6, p1.getHospitalID ());
			  st.setInt(7, p1.getPatientID());
			  st.setInt(8, p1.getAID());
			
			  
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}
		
		
		public void update(Payment p1) 
		{
			String sql = "UPDATE payment SET cardName=?,cardNo=?,zipCode=?,secCode=?,hospitalID=?,patientID=?,AID=? WHERE PayID=? ";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);

			  st.setInt(8, p1.getPayID ());
			  st.setString(1, p1.getCardName ());
			  st.setInt(2, p1.getCardNo ());
			  st.setInt(3, p1.getZipCode ());
			  st.setString(4, p1.getSecCode ());
			  st.setInt(5, p1.getHospitalID ());
			  st.setInt(6, p1.getPatientID ());
			  st.setInt(7, p1.getAID());
			  
			 st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 
			
		}



		public void deletePayment(int payid) {

			String sql = "delete from payment where PayID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(1, payid);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}
		
		public void deletePayment1(int aid) {

			String sql = "delete from payment where AID=?";
	  	 try 
		   {
			  PreparedStatement st = con.prepareStatement(sql);
			  st.setInt(7, aid);
	         st.executeUpdate();
		
			
		    } 
		 catch (Exception e) 
		  {
			
		   System.out.println(e);
		  } 

		}







		

}
