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
public class PatientDriver {

	public static void main(String[] args) {

		PatientLinkedList list = new PatientLinkedList();
		Queue q = new Queue();
		Queue sortedq = new Queue();
		
		PatientLinkedList.menu(list, q, sortedq);

	}
	

}
