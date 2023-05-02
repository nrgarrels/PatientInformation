/**************************************************************
* Name        : Patient Information Final Project
* Author      : Nick Garrels
* Created     : 5/02/2023
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program allows a user to input patient information
* 				and store it in a linked list. Also allows for users to
* 				create a wait list by patient id, and also sort that 
* 				wait list by min value of patient id.
*               Input:  Patient information from the user
*               Output: The patient information in a data structure
*               		form
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
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
