package com.flightapp.models;

import java.time.LocalDateTime;
import java.util.Date;

public class SearchModel {
		private LocalDateTime date;
		private String fromPlace;
		private String toPlace;
		private String tripType;

	public SearchModel() {
	}

	public SearchModel(LocalDateTime date, String fromPlace, String toPlace, String tripType) {
		this.date = date;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		this.tripType = tripType;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}

	@Override
	public String toString() {
		return "SearchModel[" +
				"date=" + date +
				", fromPlace='" + fromPlace + '\'' +
				", toPlace='" + toPlace + '\'' +
				", tripType='" + tripType + '\'' +
				']';
	}
}

