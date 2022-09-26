package com.flightapp.repository;

import com.flightapp.entity.Flight;
import com.flightapp.model.SearchModel;
import com.flightapp.model.SearchResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByFlightNumber(long flightNumber);

//    public List<Flight> findByFromPlaceAndToPlaceAndStartDate(String fromPlace, String toPlace, Date startDate);

    public List<Flight> findByFromPlaceAndToPlaceAndStartDateAfterAndAirlineBlockedStatus(String fromPlace, String toPlace, LocalDateTime startDate, Boolean blockedStatus);


}
