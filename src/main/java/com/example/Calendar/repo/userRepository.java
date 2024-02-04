package com.example.Calendar.repo;

import com.example.Calendar.models.userBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<userBase, Integer> {
}
