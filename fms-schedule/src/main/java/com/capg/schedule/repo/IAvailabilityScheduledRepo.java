package com.capg.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.schedule.entity.Schedule;

public interface IAvailabilityScheduledRepo extends JpaRepository<Schedule,String>{
	
	@Query(value = "from Schedule where sourceAirport=:sourceAirport")
	public Schedule existsSourceAirport(String sourceAirport);
	
	@Query(value = "from Schedule where destinationAirport=:destinationAirport")
	public Schedule existsDestinationAirport(String destinationAirport);
}


