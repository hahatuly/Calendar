package com.example.Calendar.models.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN;

    @Autowired
    public String getAuthority() {
        return name();
    }
}
