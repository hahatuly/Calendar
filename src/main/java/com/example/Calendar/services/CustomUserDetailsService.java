package com.example.Calendar.services;

import com.example.Calendar.models.userBase;
import com.example.Calendar.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private userRepository userRep;
    //@Autowired
    //private PasswordEncoder passwordEncoder;
    @Override
    //@Autowired
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userRep.findByName(name);
    }
    /*@PostMapping("/login")
    public boolean User_login(@RequestParam String name, @RequestParam String password, Model model) {
        userBase loginUser = new userBase(name, password);
        List<userBase> rUser = userRep.findAll();
        boolean trueUser = true;
        for (userBase oldUsers : rUser) {
            var oldNames = oldUsers.getName();
            var oldPasswords = oldUsers.getPassword();
            if ((oldNames.equals(loginUser.getName())) && (oldPasswords.equals(loginUser.getPassword()))) {
                trueUser = false;
                break;
            }
            //if (trueUser = true){
            //}
        }
        return trueUser;
    }*/
}
