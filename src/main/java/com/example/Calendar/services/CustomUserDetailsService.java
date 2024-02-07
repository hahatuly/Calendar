package com.example.Calendar.services;


import com.example.Calendar.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private userRepository userRep;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRep.findByName(name);
    }
}
