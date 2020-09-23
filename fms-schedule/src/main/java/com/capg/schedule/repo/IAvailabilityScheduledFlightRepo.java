package com.capg.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.schedule.entity.ScheduledFlight;

public interface IAvailabilityScheduledFlightRepo extends JpaRepository<ScheduledFlight, Long>{
	
	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ScheduledFlight c WHERE c.flightNumber = :flightNumber")
	public boolean existsByFlightNumber(long flightNumber);


}


