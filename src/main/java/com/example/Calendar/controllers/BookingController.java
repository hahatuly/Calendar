package com.example.Calendar.controllers;

import com.example.Calendar.models.bookingBase;
import com.example.Calendar.repo.bookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BookingController {

    @Autowired
    private bookingRepository bookingRep;

    @GetMapping("/Booking_time")
    public String Booking_time(Model model) {
        Iterable<bookingBase> books = bookingRep.findAll();
        model.addAttribute("books", books);
        return "Booking_time";
    }
    @PostMapping("/Booking_time")
    public String Booking_time_add(@RequestParam Date time1, @RequestParam Date time2, @RequestParam String text, Model model) {

        bookingBase events = new bookingBase(time1, time2, text);
        bookingRep.save(events);
        return "redirect:/";

    }

    @GetMapping("/Booking_time/{id}")
    public  String bookingEvents(@PathVariable(value = "id") Integer id, Model model) {
        if (!bookingRep.existsById(id)) {
            return "redirect:/Booking_time";
        }
        Optional<bookingBase> bookingEvent = bookingRep.findById(id);
        ArrayList<bookingBase> resTime1 = new ArrayList<>();
        bookingEvent.ifPresent(resTime1::add);
        ArrayList<bookingBase> resTime2 = new ArrayList<>();
        bookingEvent.ifPresent(resTime2::add);
        model.addAttribute("bookingEvent", resTime1);
        model.addAttribute("bookingEvent", resTime2);
        return "booking_events";
    }

    /*@GetMapping("/Daily_schedule/{id}/edit")
    public  String scheduleEdit(@PathVariable(value = "id") Integer id, Model model) {
        if (!scheduleRep.existsById(id)) {
            return "redirect:/Daily_schedule";
        }
        Optional<schedule> scheduleDay = scheduleRep.findById(id);
        ArrayList<schedule> resDates = new ArrayList<>();
        scheduleDay.ifPresent(resDates::add);
        model.addAttribute("scheduleDay", resDates);
        return "schedule_Edit";
    }

    @PostMapping("/Daily_schedule/{id}/edit")
    public String Daily_schedule_upd(@PathVariable(value = "id") Integer id, @RequestParam Date dates, @RequestParam String text, Model model) {
        schedule scheduleUpd = scheduleRep.findById(id).orElseThrow();
        scheduleUpd.setDate(dates);
        scheduleUpd.setText(text);
        scheduleRep.save(scheduleUpd);
        return "redirect:/Daily_schedule";
    }*/

    @PostMapping("/Booking_time/{id}/remove")
    public String Daily_schedule_delete(@PathVariable(value = "id") Integer id, Model model) {
        bookingBase scheduleDel = bookingRep.findById(id).orElseThrow();
        bookingRep.delete(scheduleDel);
        return "redirect:/Booking_time";
    }
}