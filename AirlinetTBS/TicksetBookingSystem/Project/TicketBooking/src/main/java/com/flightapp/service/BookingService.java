package com.flightapp.service;

import com.flightapp.entity.Booking;
import com.flightapp.exception.TicketBookingException;
import com.flightapp.model.BookingModel;
import com.flightapp.model.PassengerModel;
import com.flightapp.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService {
    private static int pnrIndex = 0;
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    private RestTemplate rest;

    String url = "lb://AIRLINE/airline/ticket-price/{tripType}/{flightNumber}";
    Map<String,Object> urlVariables = new HashMap<>();
    public Booking saveBooking(BookingModel model, long flightId) {
        Booking booking = new Booking();
        String pnrNumber = "PNR000"+ ++pnrIndex;
        booking.setPnrNumber(pnrNumber);
        booking.setFlightId(flightId);
        booking.setEmail(model.getEmail());
        booking.setMealType(model.getMealType());
        booking.setName(model.getName());
        booking.setNoOfSeats(model.getPassengers().size());
        StringBuilder passenger = new StringBuilder();
        for(PassengerModel p:model.getPassengers()) {
            passenger.append(p.getPassengerName())
                    .append(",")
                    .append(p.getPassengerAge())
                    .append(",")
                    .append(p.getPassengerGender())
                    .append(";");
        }
        booking.setPassengers(passenger.substring(0, passenger.length()-1));
        urlVariables.put("tripType", model.getTripType());
        urlVariables.put("flightNumber", flightId);
        ResponseEntity<Double> price = rest.getForEntity(url, double.class,urlVariables);
        booking.setFare(price.getBody() * model.getPassengers().size());
        Booking booked = bookingRepository.save(booking);
        return booked;
    }

    public String cancelTicket(String pnr) throws TicketBookingException {
        try{
            bookingRepository.deleteById(pnr);
            return pnr+" Successfully cancelled";
        }
        catch (Exception e) {
            throw new TicketBookingException("No Booking found with pnr "+pnr);
        }
    }

    public Booking getTicket(String pnr) throws TicketBookingException {
        return bookingRepository.findById(pnr).
                orElseThrow(()-> new TicketBookingException("No Booking found with pnr "+pnr));
    }

    public List<Booking> getHistory(String email) {
        return bookingRepository.findByEmail(email.toLowerCase());
    }




}
