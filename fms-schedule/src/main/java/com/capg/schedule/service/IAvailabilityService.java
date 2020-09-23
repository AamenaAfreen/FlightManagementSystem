package com.capg.schedule.service;

public interface IAvailabilityService {

	public String checkScheduledFlightById(long flightNumber);

	public boolean validFlightId(long flightNumber);

	public String checkSource(long flightNumber, String sourceAirport);
	
	public String checkDestination(long flightNumber, String destinationAirport);

	public String checkSourceAndDestination(String sourceAirport, String destinationAirport);
	
}
