package com.example.Calendar.models;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class schedule {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    public Date dates;
    private String text;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private userBase user;
    private Integer uid;
    public schedule() {
    }
    public schedule(Date dates, String text, userBase user, Integer uid) {
        this.dates = dates;
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

    public Date getDate() {
        return dates;
    }
    public void setDate(Date dates) { this.dates = dates; }

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
