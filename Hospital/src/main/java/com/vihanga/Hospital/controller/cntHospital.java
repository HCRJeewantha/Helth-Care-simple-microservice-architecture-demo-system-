package com.vihanga.Hospital.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vihanga.Hospital.config.dbconnector;
import com.vihanga.Hospital.model.Hospital;

public class cntHospital {
	
Connection con = null;
	
	public cntHospital(){
		con = dbconnector.connector();
	}
	
	public List<Hospital> getHospitals(){
		
		List<Hospital> hospitals = new ArrayList<>();
		String sql = "Select * from hospital";
		try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					Hospital h = new Hospital();
					h.setHID(rs.getInt(1));
					h.setName(rs.getString(2));
					h.setStreetNo(rs.getString(3));
					h.setCity(rs.getString(4));
					h.setPostalCode(rs.getString(5));
					h.setEmail(rs.getString(6));
					h.setAccNo(rs.getString(7));
				
					hospitals.add(h);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
				return hospitals;
	}
	
	public Hospital getHospital(int id) {
		String sql = "Select * from hospital where HID="+id;
		Hospital h = new Hospital();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				h.setHID(rs.getInt(1));
				h.setName(rs.getString(2));
				h.setStreetNo(rs.getString(3));
				h.setCity(rs.getString(4));
				h.setPostalCode(rs.getString(5));
				h.setEmail(rs.getString(6));
				h.setAccNo(rs.getString(7));			
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
				return h;
	}
	
	public void create(Hospital h1) {
		String sql = "insert into hospital values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql); 
			st.setInt(1,h1.getHID());
			st.setString(2,h1.getName());
			st.setString(3,h1.getStreetNo());
			st.setString(4,h1.getCity());
			st.setString(5,h1.getPostalCode());
			st.setString(6,h1.getEmail());
			st.setString(7,h1.getAccNo());
			st.executeUpdate();	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(Hospital h1) {
		String sql = "update hospital set Name=?,StreetNo=?,City=?,Postalcode=?,Email=?,AccNo=? WHERE HID=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,h1.getName());
			st.setString(2,h1.getStreetNo());
			st.setString(3,h1.getCity());
			st.setString(4,h1.getPostalCode());
			st.setString(5,h1.getEmail());
			st.setString(6,h1.getAccNo());
			st.setInt(7,h1.getHID());
			st.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void delete(int HID) {
		String sql = "delete from hospital where HID=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, HID);
			st.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
