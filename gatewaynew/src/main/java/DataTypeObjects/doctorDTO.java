package DataTypeObjects;

public class doctorDTO {
	private int DID;
	private String LastName;
	private String FirstName;
	private String Email;
	private String Role;
	private String DocID;
	private String Password;
	private String specialization;
	
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getDID() {
		return DID;
	}
	public void setDID(int dID) {
		DID = dID;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getDocID() {
		return DocID;
	}
	public void setDocID(String docID) {
		DocID = docID;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
}
