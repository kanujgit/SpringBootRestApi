package com.algoworks.flight.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
		Flight ft = null;
		try {
			ft = flightService.addFlight(flight);

			// TODO handle unique value violation
		} catch (DataIntegrityViolationException e) {

			return new Response<>(flight.getFlightName() + " flight already exists");

		} catch (Exception e) {

			return new Response<>(flight.getFlightName() + " flight already exists");
		}
		return new Response<Flight>(ft, "data save successfully");

	}

	@GetMapping("/")
	public Response<List<Flight>> getAllList() {
		List<Flight> list = flightService.fetchAllList();
		return new Response<List<Flight>>(list, "Flight list fetch successfully");
	}

	@GetMapping("/{name}")
	public Response<Flight> getDetailByName(@PathVariable(required = true) String name) {
		Flight list = flightService.getDetailByName(name);
		return new Response<Flight>(list, "Flight list fetch successfully");
	}

	@GetMapping("/fetchByArrDep/{departureLocation}/{arrivalLocation}")
	public Response<List<Flight>> getDetailByArrDepLoc(
			@PathVariable(value = "departureLocation", required = true) String departure,
			@PathVariable(value = "arrivalLocation", required = true) String arrived) {
		List<Flight> list = flightService.getDetByArrAndDeptLocation(departure, arrived, "");
		return new Response<List<Flight>>(list, "Flight list fetch successfully");
	}

}
