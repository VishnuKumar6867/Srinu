package com.flightapp.service;

import com.flightapp.entity.Airline;
import com.flightapp.exception.AirlineException;
import com.flightapp.model.AirlineModel;
import com.flightapp.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineService {

    @Autowired
    private AirlineRepository repository;

    public List<Airline> getAllAirlines(){
        return repository.findAll();
    }

    public Airline registerAirline(AirlineModel model) throws AirlineException{
        Airline airline = repository.findByAirlineName(model.getAirlineName());
        if(airline != null){
            throw new AirlineException("Airline with "+ airline.getAirlineName() +" name is already available");
        }
        airline = new Airline(model.getAirlineName(),model.getContactNumber(),model.getContactAddress(), false);
        return repository.save(airline);
    }

    public Airline blockAirline(String airline) throws AirlineException {
        Airline airlineEntity = repository.findByAirlineName(airline);
        if(airlineEntity == null){
            throw new AirlineException("No airline found with "+airline+" name");
        }else if(airlineEntity.getBlockedStatus()){
            throw new AirlineException(airline+" is already Blocked");
        }
        airlineEntity.setBlockedStatus(true);
        return repository.saveAndFlush(airlineEntity);
    }

    public Airline unBlockAirline(String airline) throws AirlineException {
        Airline airlineEntity = repository.findByAirlineName(airline);
        if(airlineEntity == null){
            throw new AirlineException("No airline found with "+airline+" name");
        }else if(!airlineEntity.getBlockedStatus()){
            throw new AirlineException(airline+" is already Un-Blocked");
        }
        airlineEntity.setBlockedStatus(false);
        return repository.saveAndFlush(airlineEntity);
    }
}
