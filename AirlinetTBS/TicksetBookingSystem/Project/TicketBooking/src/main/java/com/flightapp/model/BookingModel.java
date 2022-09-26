package com.flightapp.model;

import java.util.ArrayList;
import java.util.List;

public class BookingModel {
	private String name;
	private String email;
	List<PassengerModel> passengers = new ArrayList<>();
	private String mealType;
	private String tripType;

	public BookingModel() {
	}

	public BookingModel(String name, String email, List<PassengerModel> passengers, String mealType, String tripType) {
		this.name = name;
		this.email = email;
		this.passengers = passengers;
		this.mealType = mealType;
		this.tripType = tripType;
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

	public List<PassengerModel> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<PassengerModel> passengers) {
		this.passengers = passengers;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	@Override
	public String toString() {
		return "BookingModel[" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				", passengers=" + passengers +
				", mealType='" + mealType + '\'' +
				", tripType='" + tripType + '\'' +
				']';
	}
}
