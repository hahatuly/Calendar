package com.example.Calendar.services;

import com.example.Calendar.models.enums.Role;
import com.example.Calendar.models.userBase;
import com.example.Calendar.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private userRepository userRep;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public boolean createUser(userBase user) {
        if (userRep.findByName(user.getName())!=null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        return true;
    }
}
