package com.flightapp.services;

import com.flightapp.entity.LoginDetails;
import com.flightapp.models.*;
import com.flightapp.repository.LoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AdminService {

	@Autowired
	private LoginDetailsRepository adminRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private RestTemplate rest;

	private final String allAirlineURL = "lb://AIRLINE/airline/getAllAirlines";
	private final String airlineRegisterURL = "lb://AIRLINE/airline/register";
	private final String blockURL = "lb://AIRLINE/airline/block/{airline}";
	private final String unBlockURL = "lb://AIRLINE/airline/unblock/{airline}";
	private final String addFlightURL = "lb://AIRLINE/airline/addFlight";
	private final String searchFlightURL = "lb://AIRLINE/airline/searchflights";
	private final String saveBookingURL = "lb://TICKETBOOKING/booking/{flightId}";
	private final String getTicketURL = "lb://TICKETBOOKING/booking/ticket/{pnr}";
	private final String historyURL = "lb://TICKETBOOKING/booking/history/{email}";
	private final String cancelURL = "lb://TICKETBOOKING/booking/cancel/{pnr}";

	public List<AirlineResponse> getAllAirline(){
		return rest.exchange(allAirlineURL, HttpMethod.GET, null,new ParameterizedTypeReference<List<AirlineResponse>>(){}).getBody();
	}

	public AirlineResponse registerAirline(AirlineModel airlineModel) {
		return rest.exchange(airlineRegisterURL,HttpMethod.POST,new HttpEntity<>(airlineModel),AirlineResponse.class).getBody();
	}

	public AirlineResponse unBlockAirline(String airline) {
		return rest.exchange(unBlockURL,HttpMethod.PUT,null,AirlineResponse.class,airline).getBody();
	}

	public AirlineResponse blockAirline(String airline) {
		return rest.exchange(blockURL,HttpMethod.PUT,null,AirlineResponse.class,airline).getBody();
	}

	public FlightResponse addFlight(FlightModel flightModel) {
		return rest.exchange(addFlightURL,HttpMethod.POST,new HttpEntity<>(flightModel),FlightResponse.class).getBody();
	}

	public List<SearchResponse> searchFlight(SearchModel searchModel) {
		return rest.exchange(searchFlightURL,HttpMethod.POST,new HttpEntity<>(searchModel),new ParameterizedTypeReference<List<SearchResponse>>(){}).getBody();
	}

	public BookingResponse saveBooking(BookingModel model, long flightId ){
		return rest.exchange(saveBookingURL, HttpMethod.POST, new HttpEntity<>(model), BookingResponse.class, flightId).getBody();
	}

	public BookingResponse getTicket(String pnr){
		return rest.exchange(getTicketURL, HttpMethod.GET, null, BookingResponse.class, pnr).getBody();
	}

	public List<BookingResponse> historyByMail(String email){
		return rest.exchange(historyURL, HttpMethod.GET, null,new ParameterizedTypeReference<List<BookingResponse>>(){}, email).getBody();
	}

	public String cancelTicket(String pnr){
		return rest.exchange(cancelURL, HttpMethod.DELETE, null, String.class, pnr).getBody();
	}

}
