package com.example.Calendar.controllers;

import com.example.Calendar.models.bookingBase;
import com.example.Calendar.models.userBase;
import com.example.Calendar.repo.bookingRepository;
import com.example.Calendar.repo.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BookingController {

    @Autowired
    private bookingRepository bookingRep;
    @Autowired
    private userRepository userRep;
    @GetMapping("/Booking_time")
    public String Booking_time(@AuthenticationPrincipal userBase user, Model model) {
        List<bookingBase> arrayBooks = bookingRep.findAll();
        List<bookingBase> books=bookingRep.findAll();
        books.clear();
        //boolean free = true;
        for (bookingBase sched : arrayBooks) {
            if (user.getId().equals(sched.getUid())) {
                books.add(sched);
            }
        }
        model.addAttribute("books", books);
        return "Booking_time";

    }

    @PostMapping("/Booking_time")
    public String Booking_time_add(@AuthenticationPrincipal userBase user, @RequestParam LocalDateTime startTime, @RequestParam LocalDateTime endTime, @RequestParam String text, Model model) {
        bookingBase events = new bookingBase(startTime, endTime, text, user, user.getId());
        List<bookingBase> bookings = bookingRep.findAll();
        boolean free = true;
        for (bookingBase booking : bookings) {
            var StartTime = booking.getStartTime();
            var EndTime = booking.getEndTime();
            var NewInsideOld = StartTime.isBefore(events.getStartTime()) && EndTime.isAfter(events.getStartTime());
            var OldInsideNew = events.getStartTime().isBefore(StartTime) && events.getEndTime().isAfter(StartTime);
            if (NewInsideOld || OldInsideNew) {
                free = false;
                break;
            }
        }
        if (free) {
            bookingRep.save(events);
        }
        return "redirect:/";
    }

    @GetMapping("/Booking_time/{id}")
    public  String bookingEvents(@PathVariable(value = "id") Integer id, Model model) {
        if (!bookingRep.existsById(id)) {
            return "redirect:/Booking_time";
        }
        Optional<bookingBase> bookingEvent = bookingRep.findById(id);
        ArrayList<bookingBase> resStartTime = new ArrayList<>();
        bookingEvent.ifPresent(resStartTime::add);
        ArrayList<bookingBase> resEndTime = new ArrayList<>();
        bookingEvent.ifPresent(resEndTime::add);
        model.addAttribute("bookingEvent", resStartTime);
        model.addAttribute("bookingEvent", resEndTime);
        return "booking_events";
    }
}