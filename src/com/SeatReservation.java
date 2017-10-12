package com;

import java.util.Scanner;

//	SeatReservation Class which takes the input from the user and process
public class SeatReservation {

	// Main Method where the executes starts and takes the no. of seats to reserve and the passengers names for each seat and displays the no. of seats after 
	// after reservation which run as thread
	public static void main(String[] args) throws InterruptedException {
		Reservation reserve = new Reservation();			//	Reservation object
		Person personTheard = null;							//	Person thread

		Scanner userInput = new Scanner(System.in);			//	Scanner to get the user input
		int noOfTickets = 0;								//	To store the no. of tickets to reserve which is entered from the user
		int choice = 0;										//	To get the choice from the user whether to reserve tickets or to exit from the program

		System.out.println("Welcome to Online Bus Reservation Booking System");

		while (true) {										//	Loop continuously until it is interrupted
			System.out.println("Enter 1. Book Tickets and 2. Exit ");		//	Providing the choice available
			try {
				if(userInput.hasNext())						
				choice = userInput.nextInt();				//	Getting the user input for the choice
			} catch (Exception e){							//	Any other value if entered to handle exception
				System.out.println("Enter invalid choice Please Try again......");
				userInput = new Scanner(System.in);			//	To reset the user input
				continue;									//	Skipping the loop to start again
			}	
			if (choice == 1) {								//	If choice is one which i to book tickets
				System.out.print("Enter the number of tickets to be booked : ");
				
				try {
					noOfTickets = userInput.nextInt();		//	Getting the no. of tickets to be reserved
				} catch (Exception e){						//	If any other value entered hadling the exception
					System.out.println("Enter invalid number of tickets to be booked Please Try again......");
					userInput = new Scanner(System.in);		//	To reset the user input
					continue;								//	Skipping the loop to start again
				}

				String[] passengerNames = new String[noOfTickets];		//	Declaring an String array to store the Array of passengers name
				String passengerName = "";

				System.out.println("Enter the Passengers Names : ");	
				for (int i = 0; i < noOfTickets; i++) {					//	Loop to get the Passengers names from the user for each ticket reserved
					System.out.print("->");								//	and storing it in the array
					if(i==0){
						userInput.nextLine();
					}
					passengerName = userInput.nextLine();
					passengerNames[i] = passengerName;
				}

				personTheard = new Person(reserve, noOfTickets, passengerNames);	//	Creating the person thread and passing the required information which is 
				personTheard.start();												//	required for the person thread.
				while(!personTheard.status){										//	Putting the thread to sleep until the user enters the list of 
					Person.sleep(100);												//	passengers names
				}
			} else if (choice == 2) {												//	If this choice is entered it will exit from the loop 
				System.out.println("Exiting .........");
				System.out.println("Exited");
				break;
			} else {
				System.out.println("Entered invalid choice. Please enter valid choice...... ");
			}
		}

		userInput.close();															//	Closing the scanner stream to prevent memory leak
	}
}
