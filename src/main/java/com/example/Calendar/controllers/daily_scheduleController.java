package com.example.Calendar.controllers;

import com.example.Calendar.models.schedule;
import com.example.Calendar.models.userBase;
import com.example.Calendar.repo.scheduleRepository;
import com.example.Calendar.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class daily_scheduleController {

    @Autowired
    private scheduleRepository scheduleRep;
    @Autowired
    private userRepository userRep;

    @GetMapping("/Daily_schedule")
    public String Daily_schedule(Model model) {
    Iterable<schedule> schedules = scheduleRep.findAll();
        model.addAttribute("schedules", schedules);
        return "Daily_schedule";
    }
    @PostMapping("/Daily_schedule")
    public String Daily_schedule_add(@AuthenticationPrincipal userBase user, @RequestParam Date dates, @RequestParam String text, Model model) {
        schedule notes = new schedule(dates, text, user);
        scheduleRep.save(notes);
        return "redirect:/";
    }

    @GetMapping("/Daily_schedule/{id}")
    public  String scheduleDates(@PathVariable(value = "id") Integer id, Model model) {
        if (!scheduleRep.existsById(id)) {
            return "redirect:/Daily_schedule";
        }
        Optional<schedule> scheduleDay = scheduleRep.findById(id);
        ArrayList<schedule> resDates = new ArrayList<>();
        scheduleDay.ifPresent(resDates::add);
        model.addAttribute("scheduleDay", resDates);
        return "schedule_Dates";
    }

    @PostMapping("/Daily_schedule/{id}/remove")
    public String Daily_schedule_delete(@PathVariable(value = "id") Integer id, Model model) {
        schedule scheduleDel = scheduleRep.findById(id).orElseThrow();
        scheduleRep.delete(scheduleDel);
        return "redirect:/Daily_schedule";
    }
}
