package com.flightapp.controller;

import com.flightapp.entity.LoginDetails;
import com.flightapp.exception.AuthenticationException;
import com.flightapp.models.*;
import com.flightapp.services.AdminService;
import com.flightapp.services.LoginDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class AdminController {
    @Autowired
    LoginDetailsService service;
    @Autowired
    private AdminService adminService;

    @GetMapping("/home")
    public ResponseEntity<LoginDetails> home() {
        System.out.println("in home");
        return new ResponseEntity(new LoginDetails(),HttpStatus.OK);
    }

    @GetMapping("/user")
    public String userPage() {
        System.out.println("in user method");
        return "User Page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        System.out.println("in admin method");
        return "Admin Page"+service.getByUsername("admin");
    }
    @PostMapping("/home/createuser")
    public String createUser(@RequestBody LoginDetails details) throws AuthenticationException {
        details.setRole("USER");
        return service.createUser(details).toString();
    }
    @GetMapping("/home/geteuser/{username}")
    public LoginDetails getUser(@PathVariable String username) {
       return service.getByUsername(username);
    }

    @GetMapping("/home/createadmin")
    public ResponseEntity<LoginDetails> createUser() throws AuthenticationException {
        LoginDetails details = new LoginDetails("admin","admin@123", "ADMIN");
        details = service.createUser(details);
        return new ResponseEntity<>(details, details!=null ? HttpStatus.OK:HttpStatus.NO_CONTENT);
    }

    @GetMapping("/admin/airline/getAllAirlines")
    public ResponseEntity<List<AirlineResponse>> getAllAirlines(){
        List<AirlineResponse> response = adminService.getAllAirline();
        return new ResponseEntity<>(response, response != null ? HttpStatus.OK :HttpStatus.NO_CONTENT);
    }

    @PostMapping("/admin/airline/register")
    public ResponseEntity<AirlineResponse> registerAirline(@RequestBody AirlineModel airlineModel){
        AirlineResponse acknowledgement = adminService.registerAirline(airlineModel);
        return new ResponseEntity<>(acknowledgement, Objects.nonNull(acknowledgement) ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PutMapping("/admin/airline/block/{airlineName}")
    public ResponseEntity<AirlineResponse> blockAirline(@PathVariable String airlineName)
    {
        AirlineResponse acknowledgement = adminService.blockAirline(airlineName);
        return new ResponseEntity<>(acknowledgement,Objects.nonNull(acknowledgement) ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PutMapping("/admin/airline/unblock/{airlineName}")
    public ResponseEntity<AirlineResponse> unBlockAirline(@PathVariable String airlineName)
    {
        AirlineResponse acknowledgement = adminService.unBlockAirline(airlineName);
        return new ResponseEntity<>(acknowledgement,Objects.nonNull(acknowledgement) ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PostMapping("/admin/airline/addFlight")
    public ResponseEntity<FlightResponse> addFlight(@RequestBody FlightModel flightModel) {
        FlightResponse flight = adminService.addFlight(flightModel);
        return new ResponseEntity<>(flight, flight != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PostMapping("/user/airline/searchFlight")
    public ResponseEntity<List<SearchResponse>> addFlight(@RequestBody SearchModel searchModel) {
        List<SearchResponse> responses = adminService.searchFlight(searchModel);
        return new ResponseEntity<>(responses, responses != null ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    @PostMapping("/user/booking/{flightId}")
    public ResponseEntity<BookingResponse> addBooking(@RequestBody BookingModel model, @PathVariable long flightId){
        BookingResponse response = adminService.saveBooking(model, flightId);
        return new ResponseEntity<>(response, response != null ? HttpStatus.OK :HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/booking/ticket/{pnr}")
    public ResponseEntity<BookingResponse> getTicket(@PathVariable String pnr){
        BookingResponse response = adminService.getTicket(pnr);
        return new ResponseEntity<>(response, response != null ? HttpStatus.OK :HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/booking/history/{email}")
    public ResponseEntity<List<BookingResponse>> historybyMail(@PathVariable String email){
        List<BookingResponse> response = adminService.historyByMail(email);
        return new ResponseEntity<>(response, response != null ? HttpStatus.OK :HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/user/booking/cancel/{pnr}")
    public ResponseEntity<Result> cancelTicket(@PathVariable String pnr){
        String response = adminService.cancelTicket(pnr);
        Result result = new Result(response);
        return new ResponseEntity<>(result, response != null ? HttpStatus.OK :HttpStatus.NO_CONTENT);
    }
}
