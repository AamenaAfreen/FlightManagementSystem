package com.capg.schedule.service;

import java.util.List;

import com.capg.schedule.entity.Schedule;
import com.capg.schedule.entity.ScheduledFlight;

public interface IScheduleService {
 
	public ScheduledFlight addScheduledFlight(ScheduledFlight scheduledFlight);
	
public ScheduledFlight viewScheduleFlight(int scheduleId);
	
	public List<ScheduledFlight> viewScheduledFlights();
	
	public ScheduledFlight modifyScheduledFlightDetails(int scheduledFlightId, int availableSeaats, long flightNumber,
			Schedule schedule);
	
	public void deleteScheduledFlight(int scheduleId);
	
}
