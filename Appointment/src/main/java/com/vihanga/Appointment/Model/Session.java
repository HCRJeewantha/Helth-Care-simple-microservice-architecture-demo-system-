package com.vihanga.Appointment.Model;

import java.sql.Time;
import java.util.Date;

public class Session {
	
	private int SID;
	private Time startTime;
	private Time endTime;
	private Date date;
	private int hospitalID;
	private int doctorID;
	private int noOfPatients;
	private int patientLimit;
	
	public int getSID() {
		return SID;
	}
	public void setSID(int sID) {
		SID = sID;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}
	public int getNoOfPatients() {
		return noOfPatients;
	}
	public void setNoOfPatients(int noOfPatients) {
		this.noOfPatients = noOfPatients;
	}
	public int getPatientLimit() {
		return patientLimit;
	}
	public void setPatientLimit(int patientLimit) {
		this.patientLimit = patientLimit;
	}
	@Override
	public String toString() {
		return "Session [SID=" + SID + ", startTime=" + startTime + ", endTime=" + endTime + ", date=" + date
				+ ", hospitalID=" + hospitalID + ", doctorID=" + doctorID + ", noOfPatients=" + noOfPatients
				+ ", patientLimit=" + patientLimit + "]";
	}

}
