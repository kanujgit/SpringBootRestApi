package com.algoworks.flight.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.algoworks.flight.entity.Flight;

@Service
public interface FlightService {

	public Flight addFlight(Flight flight);

	public List<Flight> fetchAllList();

	public Flight getDetailByName(String name);

	public List<Flight> getDetByArrAndDeptLocation(String departure, String arrived, String sorting);

}
