package com.example.Calendar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalendarController {
    @GetMapping("/")
    public String Main_page(Model model) {
        model.addAttribute("title", "Main page");
        return "Main_page";
    }

}
