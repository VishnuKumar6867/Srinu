package com.flightapp.models;

import java.time.LocalDateTime;
import java.util.Date;

public class SearchResponse {

    private long flightNumber;
    private LocalDateTime startDate;
    private String airlineName;
    private double price;

    public SearchResponse(long fNo, LocalDateTime sdate, String airline, double price) {
        this.flightNumber = fNo;
        this.startDate = sdate;
        this.airlineName = airline;
        this.price = price;
    }

	public SearchResponse(long flightNumber, LocalDateTime startDate, String airlineName) {
		this.flightNumber = flightNumber;
		this.startDate = startDate;
		this.airlineName = airlineName;
	}

	public SearchResponse() {
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SearchResponse[" +
				"flightNumber=" + flightNumber +
				", startDate=" + startDate +
				", airlineName='" + airlineName + '\'' +
				", price=" + price +
				']';
	}
}

