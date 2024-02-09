package com.example.Calendar.repo;

import com.example.Calendar.models.schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.security.Principal;
import java.util.Optional;

public interface scheduleRepository extends JpaRepository<schedule, Integer> {
}
