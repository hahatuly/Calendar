package com.example.Calendar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class bookingBase {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    public Date time1;
    public Date time2;
    private String text;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime1() {
        return time1;
    }
    public void setTime1(Date time1) { this.time1 = time1; }

    public Date getTime2() {
        return time2;
    }
    public void setTime2(Date time2) { this.time2 = time2; }

    public String getText() {
        return text;
    }
    public void setText(String text) { this.text = text; }

    public bookingBase() {
    }
    public bookingBase(Date time1, Date time2, String text) {
        this.time1 = time1;
        this.time2 = time2;
        this.text = text;
    }


}