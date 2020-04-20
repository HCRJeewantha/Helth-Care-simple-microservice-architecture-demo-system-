package com.java;

import java.sql.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Report {
	
	private int RID;
	private String details;
	private int sessionID;
	private int patientID;
	
	


	public int getRID() {
		return RID;
	}




	public void setRID(int rID) {
		RID = rID;
	}




	public String getDetails() {
		return details;
	}




	public void setDetails(String details) {
		this.details = details;
	}




	public int getSessionID() {
		return sessionID;
	}




	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}




	public int getPatientID() {
		return patientID;
	}




	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}




	@Override
	public String toString() {
		
		return "Report [rid=" +RID + " ,details=" + details + ", sessionID=" + sessionID 
				+ ", patientID="  +patientID +"]";
	}	
	

}
