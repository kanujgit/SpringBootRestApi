package com.algoworks.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algoworks.flight.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

	public Flight findByflightName(String name);

	public List<Flight> findByDepartureLocationOrArrivalLocationOrderByPriceAsc(String departureLocation,
			String arrivalLocation);

}
