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
import java.io.*;
import java.util.Scanner;
  
//Linked List for PatientInformation
public class PatientLinkedList {
  
	//Class to create nodes for linked list
    Node head;
   public static class Node {
  
    	PatientInfo data;
    	int id;
        Node next;
  
        // Constructor
        Node(int Patientid, PatientInfo patient){
            data = patient;
            next = null;
            id = Patientid;
        }
    }
  
    // Method to insert a new node
    public static PatientLinkedList insert(PatientLinkedList list, PatientInfo patient, int patientId){
        // Creates A new Node
        Node new_node = new Node(patientId, patient);
        new_node.next = null;
  
        //Checks if list is empty
        if (list.head == null) {
            list.head = new_node;
        }else {
            //Finds Last Node
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
  
            // Insert the new_node at last node
            last.next = new_node;
        }

        return list;
    }
  
    //Print Function to print out all Patients information
    public static void printList(PatientLinkedList list){
        Node currNode = list.head;

        //Goes through the list and prints the info
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("\n");
    }
  
    //Function to delete Patient by Patient ID
    public static PatientLinkedList deleteByKey(PatientLinkedList list, int patientId){
    	
        Node currNode = list.head, prev = null;
  
        //Deletes if the patient is in head
        if (currNode != null && currNode.id == patientId) {
        	
        	// Changed head
            list.head = currNode.next; 
  
            // Display the message
            System.out.println("Patient ID: " + patientId + " found and deleted");
            return list;
        }
  
        //Search the list for the matching PatientId
        while (currNode != null && currNode.id != patientId) {
        	
            prev = currNode;
            currNode = currNode.next;
        }
  
        // If Patient id is found Deletes from list
        if (currNode != null) {
        	
            prev.next = currNode.next;
            System.out.println("Patient ID: " + patientId + " found and deleted");
            
        }
  
        //If Patient Id doesnt exist
        if (currNode == null) {
            System.out.println("Patient ID: " + patientId + " not found");
        }

        return list;
    }
  

	//Selection Menu for user
	public static void menu(PatientLinkedList list, Queue q, Queue sortedq) {
		int breakLoop = 1;
		while(breakLoop == 1) {
		//Menu For user
		System.out.println("Patient Information/Waiting Room Menu");
		System.out.println("1. Patient Information Menu");
		System.out.println("2. Waiting Room Information");
		System.out.println("3. Exit");
		System.out.println("Please Select Which Menu You would like to View: ");
		Scanner sm = new Scanner(System.in);
		String menuSelect = sm.nextLine();
		
		//1. Patient information
			if(menuSelect.equals("1")) {
				//calls the menu
				patientMenu(list, q, sortedq);
			
		//2. Waiting room queue
			}else if (menuSelect.equals("2")) {
				//calls menu
				 Queue.waitingRoomMenu(list, q, sortedq);
				 
			//exit
			}else if(menuSelect.equals("3")){
				
				System.out.println("GoodBye!");
				break;
				
			//Invalid Input
			}else {
			
				System.out.println("Invalid Input");
				
			}
		
		}
	}

	//Patient Menu to add, delete and view patients
	public static void patientMenu(PatientLinkedList list, Queue q, Queue sortedq) {
		
		//Getting User to Select what They would like to do In the Patient Information Menu
		System.out.println("Patient Information Menu");
		System.out.println("1. Add a Patient");
		System.out.println("2. Delete a Patient");
		System.out.println("3. View A Patient");
		System.out.println("4. Back to Menu");
		System.out.println("Please Select Which Menu You would like to View: ");
		Scanner spm = new Scanner(System.in);
		String patientMenu = spm.nextLine();
		
		if(patientMenu.equals("1")) {
		//a. Add a Patient 
			System.out.println("Add a Patient");
			
			//Enter Patient ID
			System.out.println("Enter Patient ID: ");
			Scanner s1 = new Scanner(System.in);
			int patientId = s1.nextInt();
			
			//Enter First Name
			System.out.println("Enter First Name: ");
			Scanner s2 = new Scanner(System.in);
			String firstName = s2.nextLine();
			
			//Enter Last Name
			System.out.println("Enter Last Name: ");
			Scanner s3 = new Scanner(System.in);
			String lastName = s3.nextLine();
	
			//Enter Phone Number
			System.out.println("Enter Phone Number: ");
			Scanner s4 = new Scanner(System.in);
			String phoneNum = s4.nextLine();
			
			//Enter Medications
			System.out.println("Enter What Medications Patient Is On: ");
			Scanner s5 = new Scanner(System.in);
			String medications = s5.nextLine();
			
			//Enter Medical History
			System.out.println("Enter Medical History: ");
			Scanner s6 = new Scanner(System.in);
			String medicalHistory = s6.nextLine();
	
			PatientInfo patient = new PatientInfo(firstName, lastName, phoneNum, medications, medicalHistory);
			
			list = insert(list, patient, patientId);
			
			System.out.println("Would You Like to Add Another Patient?(Y/N) ");
			Scanner s7 = new Scanner(System.in);
			String repeat = s7.nextLine();
			
			repeat.toLowerCase();
			
			if(repeat.equals("y")) {
				
				patientMenu(list, q, sortedq);
				
			}else {
				
				menu(list, q, sortedq);
			}
			
		}else if(patientMenu.equals("2")) {
			
			//Enter in Patient Id to delete patient
			System.out.println("Delete A Patient Menu");
			System.out.println("Please Enter PatientID: ");
			Scanner sdm = new Scanner(System.in);
			int delete = sdm.nextInt();
			deleteByKey(list, delete);
			
			System.out.println("Would You Like to Delete Another Patient?(Y/N) ");
			Scanner s8 = new Scanner(System.in);
			String repeat2 = s8.nextLine();
			
			repeat2.toLowerCase();
			
			if(repeat2.equals("y")) {
				
				patientMenu(list, q, sortedq);
				
			}else {
				
				menu(list, q, sortedq);
			}
			
			
		//c. View Patient
		}else if(patientMenu.equals("3")) {
			
			printList(list);
			
			System.out.println("Would You Like to Add/Delete/View Another Patient?(Y/N) ");
			Scanner s9 = new Scanner(System.in);
			String repeat3 = s9.nextLine();
			
			repeat3.toLowerCase();
			
			if(repeat3.equals("y")) {
				
				patientMenu(list, q, sortedq);
				
			}else {
				
				menu(list, q, sortedq);
			}
			
			//back to menu
		}else if(patientMenu.equals("4")){
			
			menu(list, q, sortedq);
			
		//If invalid input repeat menu
		}else {
			
			System.out.println("Invalid Input Please Enter Valid Input");
			
			patientMenu(list, q, sortedq);
			
			
		}
		
		
	}

}
