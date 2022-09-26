package com.flightapp.controller;

import com.flightapp.entity.Booking;
import com.flightapp.exception.TicketBookingException;
import com.flightapp.model.BookingModel;
import com.flightapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class TicketBookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/{flightId}")
    public ResponseEntity<Booking> save(@RequestBody BookingModel bookingModel, @PathVariable long flightId) {
        Booking booking = bookingService.saveBooking(bookingModel,flightId);
        return new ResponseEntity<>(booking,booking != null? HttpStatus.OK:HttpStatus.NO_CONTENT);
    }

    @GetMapping("/ticket/{pnr}")
    public ResponseEntity<Booking> getTicket(@PathVariable String pnr) throws TicketBookingException {
        Booking ticket = bookingService.getTicket(pnr);
        return new ResponseEntity<>(ticket,ticket != null? HttpStatus.OK:HttpStatus.NO_CONTENT);
    }

    @GetMapping("/history/{email}")
    public ResponseEntity<List<Booking>> getHistoryByEmailId(@PathVariable String email){
        List<Booking> bookings = bookingService.getHistory(email);
        return !CollectionUtils.isEmpty(bookings) ? new ResponseEntity<>(bookings,HttpStatus.OK) :  new ResponseEntity<>(bookings,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/cancel/{pnr}")
    public String cancelTicket(@PathVariable String pnr) throws TicketBookingException{
        return bookingService.cancelTicket(pnr);
    }
}
