package com.flightapp.service;

import com.flightapp.entity.Airline;
import com.flightapp.entity.Flight;
import com.flightapp.exception.AirlineException;
import com.flightapp.model.FlightModel;
import com.flightapp.model.SearchModel;
import com.flightapp.model.SearchResponse;
import com.flightapp.repository.AirlineRepository;
import com.flightapp.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    EntityManager em;

    public Flight addFlight(FlightModel model) throws AirlineException {
        Airline airline = airlineRepository.findByAirlineName(model.getAirlineName());

        if(airline == null){
            throw new AirlineException("Airline resource not found");
        }
        else if (model.getStartDate().isAfter(model.getEndDate())){
            throw new AirlineException("Flight start time should be before end time");
        }
        Flight flight = flightRepository.findByFlightNumber(model.getFlightNumber());
        if(flight != null){
            throw new AirlineException("Flight with "+ flight.getFlightNumber() +" is already available");
        }
        flight = new Flight(model.getFlightNumber(), model.getAirlineName(), airline, model.getFromPlace(), model.getToPlace(),
                model.getStartDate(), model.getEndDate(), model.getBusinessSeats(), model.getEconomySeats(),
                model.getTicketPrice(), model.getRows(), model.getMealType());
        return flightRepository.save(flight);
    }
    public double getTicketPrice(String tripType, long flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        double price = flight.getTicketPrice();
        if(tripType.equalsIgnoreCase("roundTrip")){
            price = price * 2;
        }
        return price;
    }

    public List<SearchResponse> getFlightData(SearchModel searchModel){
        List<Flight> flights = flightRepository.findByFromPlaceAndToPlaceAndStartDateAfterAndAirlineBlockedStatus(
                searchModel.getFromPlace(), searchModel.getToPlace(),searchModel.getDate(), false);
        List<SearchResponse> responses = new ArrayList<>();
        for (Flight flight : flights){
            responses.add(createResponse(flight, searchModel.getTripType()));
        }
        return responses;
    }

    private SearchResponse createResponse(Flight flight,String tripType) {
        SearchResponse response = new SearchResponse();
        response.setFlightNumber(flight.getFlightNumber());
        response.setAirlineName(flight.getAirline().getAirlineName());
        response.setStartDate(flight.getStartDate());
        if(tripType.equalsIgnoreCase("round trip")) {
            response.setPrice(flight.getTicketPrice() * 2);
        }
        else {
            response.setPrice(flight.getTicketPrice());
        }
        return response;
    }

}
