package com.capg.schedule.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.schedule.exceptions.ScheduledFlightIdNotFound;

@ControllerAdvice
@RestController
public class ScheduleErrorController {

	@ExceptionHandler(ScheduledFlightIdNotFound.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Scheduled Flight Id Not Found",code = HttpStatus.NOT_FOUND)
	public void ScheduledFlightIdNotFoundException() {
		
	}
	
}