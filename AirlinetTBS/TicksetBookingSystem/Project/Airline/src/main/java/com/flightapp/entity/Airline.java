package com.flightapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airlineId;
    private String airlineName;
    private String contactNumber;
    private String contactAddress;
    private Boolean blockedStatus;

    public Airline() {
    }

    public Airline(String airlineName, String contactNumber, String contactAddress, Boolean blockedStatus) {
        this.airlineName = airlineName;
        this.contactNumber = contactNumber;
        this.contactAddress = contactAddress;
        this.blockedStatus = blockedStatus;
    }

    public Airline(long airlineId, String airlineName, String contactNumber, String contactAddress, Boolean blockedStatus) {
        this(airlineName, contactNumber, contactAddress, blockedStatus);
        this.airlineId = airlineId;
    }

    public long getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(long airlineId) {
        this.airlineId = airlineId;
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

    public Boolean getBlockedStatus() {
        return blockedStatus;
    }

    public void setBlockedStatus(Boolean blockedStatus) {
        this.blockedStatus = blockedStatus;
    }

    @Override
    public String toString() {
        return "Airline[" +
                "airlineId=" + airlineId +
                ", airlineName='" + airlineName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", blockedStatus=" + blockedStatus +
                ']';
    }
}
