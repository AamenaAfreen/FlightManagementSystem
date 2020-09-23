package com.capg.schedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.schedule.entity.ScheduledFlight;
import com.capg.schedule.service.ScheduleServiceImpl;

@RestController
@RequestMapping("/schedulingFlight")
public class ScheduleController {

	@Autowired
	ScheduleServiceImpl service;
	
	@GetMapping("/a")
	public String getMessage() {
		return "Welcome";
	}
	
	@PostMapping("/add")
	public ResponseEntity<ScheduledFlight> addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight ){
		service.addScheduledFlight(scheduledFlight);
		return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.OK);
	}
	
	@GetMapping("/id/{scheduleId}")
	public ResponseEntity<ScheduledFlight> viewScheduledFlight(@PathVariable int scheduleId){
		ScheduledFlight scheduledFlight = service.viewScheduleFlight(scheduleId);
		return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.OK);
	}
	
	@GetMapping("/viewAll")
	public ResponseEntity<List<ScheduledFlight>> viewScheduleFlights(){
		List<ScheduledFlight> scheduledFlight = service.viewScheduledFlights();
		return new ResponseEntity<List<ScheduledFlight>>(scheduledFlight, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{scheduleId}")
	public ResponseEntity<ScheduledFlight> deleteScheduledFlight(@PathVariable int scheduleId) {
		service.deleteScheduledFlight(scheduleId);
		return new ResponseEntity<ScheduledFlight>(HttpStatus.OK);
	}
	
	
	@PutMapping("/modify")
	public ResponseEntity<ScheduledFlight> modifyScheduledFlightDetails(@RequestBody ScheduledFlight scheduledFlight){
		ScheduledFlight scheduledFlight1 = service.modifyScheduledFlightDetails( scheduledFlight.getScheduledFlightId(),
				scheduledFlight.getAvailableSeaats(), scheduledFlight.getFlightNumber(), scheduledFlight.getSchedule());
		return new ResponseEntity<ScheduledFlight>(scheduledFlight1, HttpStatus.OK);
	}

}

