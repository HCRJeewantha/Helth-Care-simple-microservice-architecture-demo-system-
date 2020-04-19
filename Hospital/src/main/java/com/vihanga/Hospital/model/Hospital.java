package com.vihanga.Hospital.model;

public class Hospital {
	
	public int HID;
	public String Name;
	public String StreetNo;
	public String City;
	public String PostalCode;
	public String Email;
	public String AccNo;
	public int getHID() {
		return HID;
	}
	public void setHID(int hID) {
		HID = hID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStreetNo() {
		return StreetNo;
	}
	public void setStreetNo(String streetNo) {
		StreetNo = streetNo;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPostalCode() {
		return PostalCode;
	}
	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAccNo() {
		return AccNo;
	}
	public void setAccNo(String accNo) {
		AccNo = accNo;
	}
	@Override
	public String toString() {
		return "Hospital [HID=" + HID + ", Name=" + Name + ", StreetNo=" + StreetNo + ", City=" + City + ", PostalCode="
				+ PostalCode + ", Email=" + Email + ", AccNo=" + AccNo + "]";
	}

}
