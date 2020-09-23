package com.capg.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.schedule.service.IAvailabilityService;

@RestController
@RequestMapping("/flights")
public class AvailabilityController {

	@Autowired
	IAvailabilityService service;
	
	@GetMapping("/flightNumber/{flightNumber}")
	public String checkScheduledFlightById(@PathVariable long flightNumber) {
		if(service.validFlightId(flightNumber)) {
			return service.checkScheduledFlightById(flightNumber);
		}
		return "The Flight should have 12 digits";
	}
	
	@GetMapping("/{flightNumber}/source/{sourceAirport}")
	public String checkSource(@PathVariable long flightNumber,@PathVariable String sourceAirport) {
	return service.checkSource(flightNumber, sourceAirport);
}
	
	@GetMapping("/{flightNumber}/destination/{destinationAirport}")
	public String checkDestination(@PathVariable long flightNumber,@PathVariable String destinationAirport) {
	return service.checkSource(flightNumber, destinationAirport);
}
	
	@GetMapping("/source/{sourceAirport}/destination/{destinationAirport}")
	public String checkSourceAndDestination(@PathVariable String sourceAirport, @PathVariable String destinationAirport) {
	return service.checkSourceAndDestination(sourceAirport, destinationAirport);
}
}

