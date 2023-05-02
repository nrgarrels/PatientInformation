
public class PatientInfo {
	//Patient Information variables
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String medications;
	private String medicalHistory;
	
	//Default no arg constructor
	public PatientInfo() {
		super();
		this.firstName = " ";
		this.lastName = " ";
		this.phoneNum = " ";
		this.medications = " ";
		this.medicalHistory = " ";
	}
	
	//Patient Information Constructor
	public PatientInfo(String firstName, String lastName, String phoneNum, String medications, String medicalHistory) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.medications = medications;
		this.medicalHistory = medicalHistory;
	}
	
	//Getters and Setters for Patient Information
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMedications() {
		return medications;
	}
	public void setMedications(String medications) {
		this.medications = medications;
	}
	public String getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	//Patient Information To String
	@Override
	public String toString() {
		return "Patient Information [First Name: " + firstName + " Last Name: " + lastName + " Phone Number: " + phoneNum
				+ " Medications: " + medications + " Medical History: " + medicalHistory + "]";
	}
	
	

}
