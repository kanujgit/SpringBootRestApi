package com.algoworks.flight.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algoworks.flight.entity.Flight;
import com.algoworks.flight.exception.ResourceNotFoundException;
import com.algoworks.flight.repository.FlightRepository;
import com.algoworks.flight.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Override
	public Flight addFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public List<Flight> fetchAllList() {
		List<Flight> list = flightRepository.findAll();
		if (list == null || list.size() == 0) {
			throw new ResourceNotFoundException("No Flight detail found");
		}
		return list;
	}

	@Override
	public Flight getDetailByName(String name) {
		Flight flight = flightRepository.findByflightName(name);
		if (flight == null) {
			throw new ResourceNotFoundException("" + name);
		}
		return flight;

	}

	@Override
	public List<Flight> getDetByArrAndDeptLocation(String departure, String arrived, String sorted) {
		List<Flight> list = flightRepository.findByDepartureLocationOrArrivalLocationOrderByPriceAsc(departure,
				arrived);
		if (list.size() == 0) {
			throw new ResourceNotFoundException("No Flight detail found");
		}
		return list;
	}

}
