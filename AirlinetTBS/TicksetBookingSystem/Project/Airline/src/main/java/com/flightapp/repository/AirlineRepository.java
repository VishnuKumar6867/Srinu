package com.flightapp.repository;

import com.flightapp.entity.Airline;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface AirlineRepository extends JpaRepository<Airline, Long> {
public interface AirlineRepository extends JpaRepository<Airline, Long> {

    Airline findByAirlineName(String airlineName);


}
