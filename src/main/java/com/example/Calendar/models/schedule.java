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
    //@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    //@JoinColumn
    //private userBase user;

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

    public schedule() {
    }
    public schedule(Date dates, String text) {
        this.dates = dates;
        this.text = text;
    }


}
