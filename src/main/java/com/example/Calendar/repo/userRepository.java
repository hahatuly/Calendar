package com.example.Calendar.repo;

import com.example.Calendar.models.userBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface userRepository extends JpaRepository<userBase, Integer> {
    UserDetails findByName(String name);
}
