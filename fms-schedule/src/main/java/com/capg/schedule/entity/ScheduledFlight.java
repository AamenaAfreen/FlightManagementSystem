package com.capg.schedule.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class ScheduledFlight {

	@Id
	@Column(name = "scheduledFlightId")
	private int scheduledFlightId;
	
	@Column(name = "availableSeats")
	private int availableSeaats;
	
	@Column(name = "flightNumber")
	private long flightNumber;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name= "schedule", referencedColumnName = "scheduleId")
	private Schedule schedule;
	public ScheduledFlight() {
		super();
	}

	public ScheduledFlight(int scheduledFlightId, int availableSeaats, long flightNumber, Schedule schedule) {
		super();
		this.scheduledFlightId = scheduledFlightId;
		this.availableSeaats = availableSeaats;
		this.flightNumber = flightNumber;
		this.schedule = schedule;
	}

	public int getScheduledFlightId() {
		return scheduledFlightId;
	}

	public void setScheduledFlightId(int scheduledFlightId) {
		this.scheduledFlightId = scheduledFlightId;
	}

	public int getAvailableSeaats() {
		return availableSeaats;
	}

	public void setAvailableSeaats(int availableSeaats) {
		this.availableSeaats = availableSeaats;
	}

	public long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "ScheduledFlight [scheduledFlightId=" + scheduledFlightId + ", availableSeaats=" + availableSeaats
				+ ", flightNumber=" + flightNumber + ", schedule=" + schedule + "]";
	}

	
}
