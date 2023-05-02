import java.util.*;

//Class to Create a Waiting room queue
class Queue{
	
	//Node Class to create the linked list for queue
	Node head;
	public static class Node {
	    int data;
	    Node next;
	  
	       // Constructor
	    Node(int Patientid){
	    	data = Patientid;
	        next = null;
	            
	        }
	    }
	  
	//Setting front rear and count
    private static Node rear = null, front = null;
    private static int count = 0;
 
    //Dequeue function deletes head
    public static int dequeue(){
    	
    	//Checks if empty
        if (front == null){
            System.out.println("Waiting is Room Empty");
            System.exit(-1);
        }
 
        Node temp = front;
        //System.out.printf("Removing Patient Id: ", temp.data);
 
        //Moves next node to head
        front = front.next;
 
        //reset if empty
        if (front == null) {
            rear = null;
        }
 
        count -= 1;
        return temp.data;
    }
 
    //Function to add patient to end of queue/waiting room 
    public static void enqueue(int patientId)  {
    	
        //creates new node
        Node node = new Node(patientId);
       // System.out.println("Adding Patient Id: " + patientId + " To Waiting List");
 
        //setting head of queue
        if (front == null) {
        	
            front = node;
            rear = node;
            
        //sets to back of queue
        }else {
            
            rear.next = node;
            rear = node;
        }
 
        //size
        count += 1;
    }
 
    //Function to look at top of queue
    public static int peek(){
    	
        //Checks to see if empty
        if (front == null) {
            System.exit(-1);
        }
 
        return front.data;
    }
 
    //Is empty function
    public static boolean isEmpty() {
        return rear == null && front == null;
    }
 
    // Function to return the size of the queue
    private static int size() {
        return count;
    }
    
   //Sort Algorithm Function
    static void FrontToLast(Queue q, int qsize){
    	// Base condition
    	if (qsize <= 0)
    		return;

    	// pop front element and push
    	// this last in a queue
    	q.enqueue(q.peek());
    	q.dequeue();

    	// Recursive call for pushing element
    	FrontToLast(q, qsize - 1);
    }

    //Function to push an element in the queue
    //while maintaining the sorted order
    static void pushInQueue(Queue q, int temp, int qsize){

    	// Base condition
    	if (q.isEmpty() || qsize == 0){
    		q.enqueue(temp);
    		return;
    	}

    	// If current element is less than
    	// the element at the front
    	else if (temp <= q.peek()){

    		// Call stack with front of queue
    		q.enqueue(temp);

    		// Recursive call for inserting a front
    		// element of the queue to the last
    		FrontToLast(q, qsize);
    		
    	}else{

    		// Push front element into
    		// last in a queue
    		q.enqueue(q.peek());
    		q.dequeue();

    		// Recursive call for pushing
    		// element in a queue
    		pushInQueue(q, temp, qsize - 1);
    	}
    }

    //Function to sort the given
    //queue using recursion
    static Queue sortQueue(Queue q){

    	// Return if queue is empty
    	if (q.isEmpty())
    		return q;

    	// Get the front element which will
    	// be stored in this variable
    	// throughout the recursion stack
    	int temp = q.peek();

    	// Remove the front element
    	q.dequeue();

    	// Recursive call
    	sortQueue(q);

    	// Push the current element into the queue
    	// according to the sorting order
    	pushInQueue(q, temp, q.size());
    	
    	return q;
}
    
    
    public static void waitingRoomMenu(PatientLinkedList list, Queue q, Queue sortedq) {

    	//2. Waiting room queue
    	//Getting User to Select what They would like to do In the Patient Information Menu
    	System.out.println("Waiting Room");
    	System.out.println("1. Add a Patient to the Waiting Room Queue");
    	System.out.println("2. Remove a Patient From the Waiting Room Queue");
    	System.out.println("3. View Next Patient in the Queue");
    	System.out.println("4. View How Many Patients Are In the Waiting Room");
    	System.out.println("5. Sort Wating Room Patients by Patient Id");
    	System.out.println("6. Exit To Main Menu");
    	System.out.println("Please Select Which Menu You would like to View: ");
    	Scanner s1 = new Scanner(System.in);
    	String waitingSelect = s1.nextLine();
    			
		//a. Add person to queue
    	if(waitingSelect.equals("1")) {
    		
    		System.out.println("Add a Patient");
			
    		//Enter Patient ID
    		System.out.println("Enter Patient ID: ");
			Scanner s2 = new Scanner(System.in);
			int patientId = s2.nextInt();
			
			q.enqueue(patientId);
			System.out.println("Adding Patient Id: " + patientId + " to Waiting Room");
			
			//Puts user in menu they would like to view next
			System.out.println("Would You Like to Add/Remove/View Another Patient in Wait List?(Y/N) ");
			Scanner s7 = new Scanner(System.in);
			String repeat = s7.nextLine();
			
			repeat.toLowerCase();
			
			if(repeat.equals("y")) {
				
				waitingRoomMenu(list, q, sortedq);
				
			}else {
				
				PatientLinkedList.menu(list, q, sortedq);
			}
			
			
    		
    	//b. Remove person from queue
    	}else if(waitingSelect.equals("2")) {
    		
    		//Getting user conformation to remove the top person in queue
    		System.out.println("Are Your sure you would like to remove Patient Id " + q.peek() + " Y/N");
    		Scanner s9 = new Scanner(System.in);
			String repeat3 = s9.nextLine();
			
			repeat3.toLowerCase();
			
			//Confirms Deletion
			if(repeat3.equals("y")) {
				
				System.out.println("Removing Patient Id: " + q.dequeue());
				waitingRoomMenu(list, q, sortedq);
				
			}else {
				
				waitingRoomMenu(list, q, sortedq);
			}
    		
    		
    	//c. Look at top of queue
    	}else if(waitingSelect.equals("3")) {
    		
    		//Makes sure queue is not empty before peek
    		if(q.size() > 0) {
    		
    		System.out.println("Next In Line Patient Id: " + q.peek());
    		
    		waitingRoomMenu(list, q, sortedq);
    		
    		}else {
    			
    			System.out.println("Waiting Room is Empty");
        		
        		waitingRoomMenu(list, q, sortedq);
    		}
    		
    	//d. Check how many people in queue	
    	}else if(waitingSelect.equals("4")) {
    	
    		//Makes sure queue is not empty before showing size
    		if(q.size() > 0) {
    			System.out.println("There are " + q.size() + " Patient(s) in line");
    		
    			waitingRoomMenu(list, q, sortedq);
    		
    		}else {
			
    			System.out.println("Waiting Room is Empty");
    		
    			waitingRoomMenu(list, q, sortedq);
		}
    	
    	//e. Sorts Queue by Patient id and outputs queue
    	}else if(waitingSelect.equals("5")) {
    		
    		//Calls the Sort Function and sorts the waiting room queue
    		sortedq = sortQueue(q);
    		
    		int n = sortedq.size();
    		
    		//Loop to print out the sorted queue in order
    		for(int i = 0; i < n; i++) {
    			
    		System.out.println("Patient Id: " + sortedq.dequeue());
    			
    		}
    		
    		
    		PatientLinkedList.menu(list, q, sortedq);
    	
    	//f. Return to main menu
    	}else if(waitingSelect.equals("6")) {
    		
    		
    		PatientLinkedList.menu(list, q, sortedq);
    		
    	}
		
		
		
    	
    	
    }
}