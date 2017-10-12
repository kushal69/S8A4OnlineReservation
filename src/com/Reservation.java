package com;

//	Reservation Class which uses synchronized reserveSeat method to book the seats
public class Reservation {

	static int availableSeats = 50; // Static int Variable to define available seats.

	// Synchronized reserveSeat method to reserve tickets which takes 2 arguments
	// @param requestedSeats = no. of seats for booking if available
	// @param passengerNames = array of passengers names to display
	synchronized void reserveSeat(int requestedSeats, String[] passengerNames) {

		System.out.println("Available Seats : " + availableSeats + " Requested Seats : " + requestedSeats);

		if (availableSeats >= requestedSeats) { // Checks if the entered no. of seats available to reserve
			System.out.println("Seat are Available. Reserving now.......");

			System.out
					.println(requestedSeats + " Seats Reserved and below are the Names under which seats are booked.");

			for (String name : passengerNames) { // Loop to print the Passengers name
				System.out.println("-> " + name);
			}

			availableSeats = availableSeats - requestedSeats; // Calculating the final available seats

			System.out.println("Total no. of available Seats after reservation is : " + availableSeats); // Printing the no. seats available as a report
		} else {
			System.out.println("Requested Seats are not available");
		}
		System.out.println("----------------------------------------------");
	}
}