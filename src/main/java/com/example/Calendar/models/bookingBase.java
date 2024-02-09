package com.example.Calendar.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class bookingBase {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
    private String text;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private userBase user;
    private Integer uid;
    public bookingBase() {
    }
    public bookingBase(LocalDateTime startTime, LocalDateTime endTime, String text, userBase user, Integer uid) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.text = text;
        this.user = user;
        this.uid = uid;
    }
    public String getUserName() {
        return user !=null ? user.getUsername() : "<none>";
    }
    public userBase getUser() {
        return user;
    }
    public void setUser(userBase user) { this.user = user; }

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
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
}