package DataTypeObjects;

public class paymentDTO {
	private int PayID ;
	private String cardName ;
	private int cardNo ;
	private int zipCode ;
	private String secCode ;
	private int hospitalID ;
	private int patientID ;
	private int AID;
	public int getPayID() {
		return PayID;
	}
	public void setPayID(int payID) {
		PayID = payID;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public int getCardNo() {
		return cardNo;
	}
	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getSecCode() {
		return secCode;
	}
	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}
	public int getHospitalID() {
		return hospitalID;
	}
	public void setHospitalID(int hospitalID) {
		this.hospitalID = hospitalID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getAID() {
		return AID;
	}
	public void setAID(int aID) {
		AID = aID;
	}
}
