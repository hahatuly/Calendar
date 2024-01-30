package com.example.Calendar.repo;

import com.example.Calendar.models.bookingBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookingRepository extends JpaRepository<bookingBase, Integer> {

}