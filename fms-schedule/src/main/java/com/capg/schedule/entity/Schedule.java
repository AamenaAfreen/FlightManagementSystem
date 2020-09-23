package com.capg.schedule.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Schedule {
	
	@Id
	@Column(name = "scheduleId")
	private int scheduleId;
	
	@Column(name = "sourceAirpot")
	private String sourceAirpot;
	
	@Column(name = "destinationAirpot")
	private String destinationAirpot;
	
	@Column(name = "arrivalTime")
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime arrivalTime;
	
	@Column(name = "departureTime")
	@DateTimeFormat(pattern = "yyyy/MM/ddThh:mm:ss")
	private LocalDateTime departureTime;

	public Schedule() {
		super();
	}

	public Schedule(int scheduleId, String sourceAirpot, String destinationAirpot, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.scheduleId = scheduleId;
		this.sourceAirpot = sourceAirpot;
		this.destinationAirpot = destinationAirpot;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSourceAirpot() {
		return sourceAirpot;
	}

	public void setSourceAirpot(String sourceAirpot) {
		this.sourceAirpot = sourceAirpot;
	}

	public String getDestinationAirpot() {
		return destinationAirpot;
	}

	public void setDestinationAirpot(String destinationAirpot) {
		this.destinationAirpot = destinationAirpot;
	}

	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sourceAirpot=" + sourceAirpot + ", destinationAirpot="
				+ destinationAirpot + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}

	
}
