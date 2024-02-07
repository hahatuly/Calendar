package com.example.Calendar.models;

import jakarta.persistence.*;

import java.security.Principal;
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
    public schedule() {
    }
    public schedule(Date dates, String text, userBase user) {
        this.dates = dates;
        this.text = text;
        this.user = user;
    }
    public String getUserName() {
        return user !=null ? user.getUsername() : "<none>";
    }
    public userBase getUser() {
        return user;
    }
    public void setUser(userBase user) { this.user = user; }
    //@Autowired
    //private userRepository userRep;
    //private Integer user_id;

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

    /*public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }*/

}
