package com.example.Calendar.controllers;

import com.example.Calendar.models.enums.Role;
import com.example.Calendar.models.userBase;
import com.example.Calendar.repo.userRepository;
import com.example.Calendar.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private userRepository userRep;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/Registration")
    public String Registration(Model model) {
        Iterable<userBase> users = userRep.findAll();
        model.addAttribute("users", users);
        return "Registration";
    }
    @PostMapping("/Registration")
    public String User_add(@RequestParam String name, @RequestParam String password, Model model) {
        userBase regularUser = new userBase(name, password);
        List<userBase> user = userRep.findAll();
        boolean free = true;
        for (userBase oldUsers : user) {
            var oldNames = oldUsers.getName();
            if (oldNames.equals(regularUser.getName())) {
                free = false;
                break;
            }
        }
        if (free) {
            regularUser.setPassword(passwordEncoder.encode(regularUser.getPassword()));
            regularUser.getRoles().add(Role.ROLE_USER);
            userRep.save(regularUser);
        }
        if (free==false) {
            model.addAttribute("errorMessage", "user with this name is already have");
        }
        return "redirect:/";
    }
    /*@GetMapping("/Daily_schedule")
    public String securityUrl() {
        return "/Daily_schedule";
    }*/

    /*@GetMapping("/Booking_time")
    public String securityUrl2() {
        return "/Booking_time";
    }*/

    /*@Autowired
    private userRepository userRep;

    @GetMapping("/Registration")
    public String Registration(Model model) {
        Iterable<userBase> users = userRep.findAll();
        model.addAttribute("users", users);
        return "Registration";
    }
    @PostMapping("/Registration")
    public String User_add(@RequestParam String name, @RequestParam String password, Model model) {
        userBase regularUser = new userBase(name, password);
        List<userBase> user = userRep.findAll();
        boolean free = true;
        for (userBase oldUsers : user) {
            var oldNames = oldUsers.getName();
            if (oldNames.equals(regularUser.getName())) {
                free = false;
                break;
            }
        }
        if (free) {
            userRep.save(regularUser);
        }
        if (free==false) {
            model.addAttribute("errorMessage", "user with this name is already have");
        }
        return "redirect:/";
    }







    @GetMapping("/Registration")
    public String Registration() {
        return "Registration";
    }

    @PostMapping("/Registration")
    public String createUser(userBase user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "user with this name is already have");
            return "Registration";
        }
        return "redirect:/login";
    }








    @PostMapping("/login")
    public String User_login(@RequestParam String name, @RequestParam String password, Model model) {
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
        }
        return "redirect:/";
    }*/
}