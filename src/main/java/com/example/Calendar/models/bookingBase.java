package com.example.Calendar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//import java.sql.Date;
import java.time.LocalDateTime;

@Entity
public class bookingBase {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    private String text;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime;}
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public String getText() {
        return text;
    }
    public void setText(String text) { this.text = text; }

    public bookingBase() {
    }
    public bookingBase(LocalDateTime startTime, LocalDateTime endTime, String text) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.text = text;
    }


}