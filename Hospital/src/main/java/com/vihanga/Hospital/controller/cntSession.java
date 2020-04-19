package com.vihanga.Hospital.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vihanga.Hospital.config.dbconnector;
import com.vihanga.Hospital.model.Session;

public class cntSession {
	
Connection con = null;
	
	public cntSession() {
		
		con = dbconnector.connector();
	}
	
	public List<Session> getSessions(){
		List<Session> session = new ArrayList<>();
		String sql = "Select * from sessions";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Session s = new Session();
				s.setSID(rs.getInt(1));
				s.setStartTime(rs.getString(2));
				s.setEndTime(rs.getString(3));
				s.setDate(rs.getString(4));
				s.setHospitalID(rs.getInt(5));
				s.setDoctorID(rs.getInt(6));
				s.setNoOfPatients(rs.getInt(7));
				s.setPatientLimit(rs.getInt(8));
				
				session.add(s);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
				return session;
	}
	
	public List<Session> getSpecificSessions(int did,int did1){
		List<Session> session = new ArrayList<>();
		String sql = "Select * from sessions where doctorID="+1+" and hospitalID="+1;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Session s = new Session();
				s.setSID(rs.getInt(1));
				s.setStartTime(rs.getString(2));
				s.setEndTime(rs.getString(3));
				s.setDate(rs.getString(4));
				s.setHospitalID(rs.getInt(5));
				s.setDoctorID(rs.getInt(6));
				s.setNoOfPatients(rs.getInt(7));
				s.setPatientLimit(rs.getInt(8));
				
				session.add(s);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
				return session;
	}
	
	public Session getSession(int id) {
		String sql = "Select * from hospital where HID="+id;
		Session s = new Session();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				s.setSID(rs.getInt(1));
				s.setStartTime(rs.getString(2));
				s.setEndTime(rs.getString(3));
				s.setDate(rs.getString(4));
				s.setHospitalID(rs.getInt(5));
				s.setDoctorID(rs.getInt(6));
				s.setNoOfPatients(rs.getInt(7));
				s.setPatientLimit(rs.getInt(8));
				
				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
				return s;
	}
	
	public void create(Session s1) {
		String sql = "insert into sessions values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql); 
			st.setInt(1,s1.getSID());
			st.setString(2,s1.getStartTime());
			st.setString(3,s1.getEndTime());
			st.setString(4,s1.getDate());
			st.setInt(5,s1.getHospitalID());
			st.setInt(6,s1.getDoctorID());
			st.setInt(7,s1.getNoOfPatients());
			st.setInt(8,s1.getPatientLimit());
			st.executeUpdate();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void update(Session s1) {
		String sql = "update sessions set startTime=?,endTime=?,date=?,hospitalID=?,doctorID=?,noOfPatients=?,patientLimit=? where SID=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,s1.getStartTime());
			st.setString(2,s1.getEndTime());
			st.setString(3,s1.getDate());
			st.setInt(4,s1.getHospitalID());
			st.setInt(5,s1.getDoctorID());
			st.setInt(6,s1.getNoOfPatients());
			st.setInt(7,s1.getPatientLimit());
			st.setInt(8,s1.getSID());
			st.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void delete(int SID) {
		String sql = "delete from sessions where SID=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, SID);
			st.executeUpdate();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
