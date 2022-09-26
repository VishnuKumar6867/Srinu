package com.flightapp.model;

public class AirlineModel {
    private String airlineName;
    private String contactNumber;
    private String contactAddress;

    public AirlineModel(String airlineName, String contactNumber, String contactAddress) {
        this.airlineName = airlineName;
        this.contactNumber = contactNumber;
        this.contactAddress = contactAddress;
    }

    public AirlineModel() {
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }
}
