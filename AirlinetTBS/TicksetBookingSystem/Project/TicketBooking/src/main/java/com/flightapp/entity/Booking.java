package com.flightapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	private String pnrNumber;
	private long flightId;
	private String name;
	private String email;
	private int noOfSeats;
	private String passengers;
	private String mealType;
	private double fare;

	public Booking() {
	}

	public Booking(String pnrNumber, long flightId, String name, String email, int noOfSeats, String passengers,
				   String mealType, double fare) {
		this.pnrNumber = pnrNumber;
		this.flightId = flightId;
		this.name = name;
		this.email = email;
		this.noOfSeats = noOfSeats;
		this.passengers = passengers;
		this.mealType = mealType;
		this.fare = fare;
	}

	public String getPnrNumber() {
		return pnrNumber;
	}

	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getPassengers() {
		return passengers;
	}

	public void setPassengers(String passengers) {
		this.passengers = passengers;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Booking[" +
				"pnrNumber='" + pnrNumber + '\'' +
				", flightId=" + flightId +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", noOfSeats=" + noOfSeats +
				", passengers='" + passengers + '\'' +
				", mealType='" + mealType + '\'' +
				", fare=" + fare +
				']';
	}
}
