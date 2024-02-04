package com.example.Calendar.controllers;

import com.example.Calendar.models.userBase;
import com.example.Calendar.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
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
        return "redirect:/";
    }
}