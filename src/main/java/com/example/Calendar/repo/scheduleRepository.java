package com.example.Calendar.repo;

import com.example.Calendar.models.schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.security.Principal;

public interface scheduleRepository extends JpaRepository<schedule, Integer> {
}
