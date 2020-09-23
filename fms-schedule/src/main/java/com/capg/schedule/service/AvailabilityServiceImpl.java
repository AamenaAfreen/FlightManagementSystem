package com.capg.schedule.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.capg.schedule.exceptions.InvalidInputException;
import com.capg.schedule.repo.IAvailabilityScheduledFlightRepo;
import com.capg.schedule.repo.IAvailabilityScheduledRepo;

public class AvailabilityServiceImpl implements IAvailabilityService{

	@Autowired
	IAvailabilityScheduledFlightRepo flightRepo;
	@Autowired
	IAvailabilityScheduledRepo scheduleRepo;
	
	@Override
	public String checkScheduledFlightById(long flightNumber) {
		// TODO Auto-generated method stub
		if(!(flightRepo.existsByFlightNumber(flightNumber))){
			//	existsByFlightNumber(flightNumber)) 
			System.out.println(flightNumber);
			throw new InvalidInputException("No availability");
		}
		return "The flight is available";
	}

	@Override
	public boolean validFlightId(long flightNumber) {
		int count=0;
		while(flightNumber>0) {
			count++;
			flightNumber=flightNumber/10;
		}
		
		if(count<12 || count>12) {
			throw new InvalidInputException("ID should be of 12 digits");	
		}
		return true;
	}

	@Override
	public String checkSource(long flightNumber, String sourceAirport) {
		if(flightRepo.existsByFlightNumber(flightNumber)) {
			if(!scheduleRepo.findAll().contains(scheduleRepo.existsSourceAirport(sourceAirport))) {
				throw new InvalidInputException("No availability");
			}
		}	
		return "Source Airport is valid";
	}

	@Override
	public String checkSourceAndDestination(String sourceAirport, String destinationAirport) {
		// TODO Auto-generated method stub
		if(!scheduleRepo.findAll().contains(scheduleRepo.existsSourceAirport(sourceAirport))) {
			throw new InvalidInputException("No availability");
		}
		else if(flightRepo.findAll().contains(scheduleRepo.existsDestinationAirport(destinationAirport))) {
			throw new InvalidInputException("No availability");
		}
	return "Flight is available";
		
	}

	@Override
	public String checkDestination(long flightNumber, String destinationAirport) {
		// TODO Auto-generated method stub
		if(flightRepo.existsByFlightNumber(flightNumber)) {
			if(!scheduleRepo.findAll().contains(scheduleRepo.existsDestinationAirport(destinationAirport))) {
				throw new InvalidInputException("No availability");
			}
		}	
		return "Destination Airport is valid";
	}

}
