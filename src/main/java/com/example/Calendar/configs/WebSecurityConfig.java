package com.example.Calendar.configs;

import com.example.Calendar.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/Registration").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }
    private CustomUserDetailsService userDetailsService;
    //@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
                //.passwordEncoder(passwordEncoder());
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }*/
    /*@Autowired
    private userRepository userRep;
    @PostMapping("/login")
    public String User_login(@RequestParam String name, @RequestParam String password, Model model) {
        userBase loginUser = new userBase(name, password);
        List<userBase> rUser = userRep.findAll();
        boolean trueUser = true;
        for (userBase oldUsers : rUser) {
            var oldNames = oldUsers.getName();
            var oldPasswords = oldUsers.getPassword();
            if ((oldNames.equals(loginUser.getName())) && (oldPasswords.equals(loginUser.getPassword()))) {
                trueUser = false;
                break;
            }
            if (trueUser = true){
                .permitAll();
            }
        }
        return "redirect:/";
    }*/
}