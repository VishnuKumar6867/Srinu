package com.flightapp.controller;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Flight;
import com.flightapp.exception.AirlineException;
import com.flightapp.model.AirlineModel;
import com.flightapp.model.FlightModel;
import com.flightapp.model.SearchModel;
import com.flightapp.model.SearchResponse;
import com.flightapp.service.AirlineService;
import com.flightapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/airline")
public class AirlineController {
    @Autowired
    AirlineService airlineService;

    @Autowired
    FlightService flightService;

    //@Autowired
   // private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "Airline";

    @GetMapping("/getAllAirlines")
    public ResponseEntity<List<Airline>> getAllAirlines(){
        return new ResponseEntity<>(airlineService.getAllAirlines(), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Airline> registerAirline(@RequestBody AirlineModel airlineModel) throws AirlineException {
        Airline airline = airlineService.registerAirline(airlineModel);
//        kafkaTemplate.send(TOPIC, airline + " Successfully registered");
        return new ResponseEntity<>(airline, airline != null ? HttpStatus.OK:HttpStatus.NO_CONTENT);
    }

    @PutMapping("/block/{airline}")
    public ResponseEntity<Airline> blockAirline(@PathVariable("airline") String airline) throws AirlineException {
        Airline airlineEntity = airlineService.blockAirline(airline);
//        kafkaTemplate.send(TOPIC, airline + " Successfully Blocked");
        return new ResponseEntity<>(airlineEntity, airlineEntity != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PutMapping("/unblock/{airline}")
    public ResponseEntity<Airline> unBlockAirline(@PathVariable("airline") String airline) throws AirlineException {
        Airline airlineEntity = airlineService.unBlockAirline(airline);
//        kafkaTemplate.send(TOPIC, airline + " Successfully UnBlocked");
        return new ResponseEntity<>(airlineEntity, airlineEntity != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PostMapping("/addFlight")
    public ResponseEntity<Flight> addFlight(@RequestBody FlightModel flightModel) throws AirlineException {
        Flight flight = flightService.addFlight(flightModel);
//        kafkaTemplate.send(TOPIC, flight + " Successfully registered");
        return new ResponseEntity<>(flight, flight != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
    @GetMapping("/ticket-price/{tripType}/{flightNumber}")
    public double getPrice(@PathVariable String tripType, @PathVariable long flightNumber) {
        return flightService.getTicketPrice(tripType,flightNumber);
    }

    @PostMapping("/searchflights")
    public ResponseEntity<List<SearchResponse>> getFlightData(@RequestBody SearchModel searchModel) throws AirlineException {
        List<SearchResponse> responses = flightService.getFlightData(searchModel);
        //        kafkaTemplate.send(TOPIC, flight + " Successfully registered");
        return new ResponseEntity<>(responses, responses != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

}
