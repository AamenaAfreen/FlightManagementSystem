package com.capg.schedule.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.schedule.entity.Schedule;
import com.capg.schedule.entity.ScheduledFlight;
import com.capg.schedule.exceptions.ScheduledFlightIdNotFound;
import com.capg.schedule.repo.IScheduleRepo;

@Service
public class ScheduleServiceImpl implements IScheduleService{
	
	@Autowired
	IScheduleRepo repo;

	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight) {
		// TODO Auto-generated method stub
		return repo.save(scheduledFlight);
	}

	public ScheduledFlight viewScheduleFlight(int scheduleId) {
		// TODO Auto-generated method stub
		if(!(repo.existsById(scheduleId))) {
			throw new ScheduledFlightIdNotFound("Schedule Flight Id is not found");
		}
		return repo.findById(scheduleId).get();
	}

	public List<ScheduledFlight> viewScheduledFlights() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	
	@Override
	public void deleteScheduledFlight(int scheduleId) {
		if (! (repo.existsById(scheduleId))) {
			throw new ScheduledFlightIdNotFound("Scheduled Flight Id is not found");
		}
		repo.deleteById(scheduleId);
		
	}

	public ScheduledFlight modifyScheduledFlightDetails(int scheduledFlightId, int availableSeaats, long flightNumber,
			Schedule schedule) {
		// TODO Auto-generated method stub
		if (! repo.existsById(scheduledFlightId)) {
			throw new ScheduledFlightIdNotFound("Scheduled Flight Id is not found");
		}
			ScheduledFlight scheduledFlight = repo.getOne(scheduledFlightId);
			scheduledFlight.setAvailableSeaats(availableSeaats);
			scheduledFlight.setFlightNumber(flightNumber);
			scheduledFlight.setSchedule(schedule);
			repo.save(scheduledFlight);
		return scheduledFlight;
	}

	
}