package com.algoworks.flight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algoworks.flight.api.reponse.Response;
import com.algoworks.flight.entity.Flight;
import com.algoworks.flight.service.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	FlightService flightService;

	@PostMapping("/")
	public Response<Flight> saveDetail(@Valid @RequestBody Flight flight) {
		Flight ft = flightService.addFlight(flight);
		return new Response<Flight>(ft, "data save successfully");
	}

	@GetMapping("/")
	public Response<List<Flight>> getAllList() {
		List<Flight> list = flightService.fetchAllList();
		return new Response<List<Flight>>(list, "Flight list fetch successfully");
	}

	@PostMapping("/{name}")
	public Response<Flight> getDetailByName(@PathVariable(required = true) String name) {
		Flight list = flightService.getDetailByName(name);
		return new Response<Flight>(list, "Flight list fetch successfully");
	}

}
