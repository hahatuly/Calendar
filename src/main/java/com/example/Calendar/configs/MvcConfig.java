package com.example.Calendar.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/");
        registry.addViewController("/Daily_schedule").setViewName("/Daily_schedule");
        registry.addViewController("/Booking_time").setViewName("/Booking_time");
        registry.addViewController("/Registration").setViewName("/Registration");
        registry.addViewController("/login").setViewName("login");
    }

}