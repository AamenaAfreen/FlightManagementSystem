package com.capg.schedule.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.schedule.entity.ScheduledFlight;

public interface IScheduleRepo extends JpaRepository<ScheduledFlight, Integer>{

}
