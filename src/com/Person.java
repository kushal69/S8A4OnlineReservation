package com;

// Person Class which extending Thread class
class Person extends Thread {
	// Few Class variables
	Reservation reserve;
	int requestedSeats;
	String[] passengerNames;
	boolean status = false;

	//	Person Constructor to initialize class variables with the data sent from the user while initializing 
	//	@param reserve = Reservation object which contains the synchronized method to reserve
	//	@param requestedSeats = No. of tickets to be booked
	//	@param passengerNames = Passengers Names
	public Person(Reservation reserve, int requestedSeats, String[] passengerNames) {
		this.reserve = reserve;
		this.requestedSeats = requestedSeats;
		this.passengerNames = passengerNames;
	}

	//	Run method which override run method of the Thread Class and calls the reserveSeat method of the Reservation class with requested number of seats and 
	//	passengers array names after Reservation done setting the status as true which will be used to wake the thread until then it will be sleeping.
	@Override
	public void run() {
		reserve.reserveSeat(requestedSeats, passengerNames);		//	Calling Reservation method
		status = true;
	}
}
