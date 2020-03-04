package com.algoworks.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "flights")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@NotEmpty(message = "Please enter flight name")
	@Size(max = 20, min = 2, message = "Please enter valid flight name")
	@Column(name = "flight_name", unique = true)
	private String flightName;

	@NotEmpty(message = "Please enter departure location ")
	@Column(name = "departure_location")
	private String departureLocation;

	@NotEmpty(message = "Please enter Departure date")
	@Column(name = "departure_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private String departureDate;

	@NotEmpty(message = "Please enter Departure Time")
	@Column(name = "departure_time")
	private String departureTime;

	@NotEmpty(message = "Please enter arrival date")
	@Column(name = "arrival_date")
	private String arrivalDate;

	@NotEmpty(message = "Please enter arrival time")
	@Column(name = "arrival_time")
	private String arrivalTime;

	@NotEmpty(message = "Please enter arrival location")
	@Column(name = "arrival_location")
	private String arrivalLocation;

	@Column(name = "price")
	private Double price;

	@Column(name = "total_passanger")
	private Integer numberOfPassanger;

	@Column(name = "duration")
	@NotNull(message = "Please enter duration ")
	private Double duration;

}
