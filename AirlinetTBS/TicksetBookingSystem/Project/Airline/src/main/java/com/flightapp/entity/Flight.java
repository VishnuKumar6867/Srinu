package com.flightapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long flightId;
    private long flightNumber;

    private String airlineName;
    @ManyToOne
    @JoinColumn(name = "airlineId")
    private Airline airline;
    private String fromPlace;
    private String toPlace;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int businessSeats;
    private int economySeats;
    private double ticketPrice;
    private int rows;
    private String mealType;

    public Flight() {
    }

    public Flight(long flightNumber, String airlineName, Airline airline, String fromPlace, String toPlace, LocalDateTime startDate, LocalDateTime endDate,
                  int businessSeats, int economySeats, double ticketPrice, int rows, String mealType) {
        this.flightNumber = flightNumber;
        this.airlineName = airlineName;
        this.airline = airline;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.startDate = startDate;
        this.endDate = endDate;
        this.businessSeats = businessSeats;
        this.economySeats = economySeats;
        this.ticketPrice = ticketPrice;
        this.rows = rows;
        this.mealType = mealType;
    }

    public Flight(long flightId, long flightNumber, String airlineName, Airline airline, String fromPlace, String toPlace, LocalDateTime startDate,
                  LocalDateTime endDate, int businessSeats, int economySeats, double ticketPrice, int rows, String mealType) {
        this(flightNumber, airlineName, airline, fromPlace, toPlace, startDate, endDate, businessSeats,
                economySeats, ticketPrice, rows, mealType);
        this.flightId = flightId;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(long flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(int businessSeats) {
        this.businessSeats = businessSeats;
    }

    public int getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(int economySeats) {
        this.economySeats = economySeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    @Override
    public String toString() {
        return "Flight[" +
                "flightId=" + flightId +
                ", flightNumber=" + flightNumber +
                ", airline=" + airline +
                ", fromPlace='" + fromPlace + '\'' +
                ", toPlace='" + toPlace + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", businessSeats=" + businessSeats +
                ", economySeats=" + economySeats +
                ", ticketPrice=" + ticketPrice +
                ", rows=" + rows +
                ", mealType='" + mealType + '\'' +
                ']';
    }
}
