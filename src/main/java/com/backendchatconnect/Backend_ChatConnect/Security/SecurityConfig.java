package com.backendchatconnect.Backend_ChatConnect.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/getId/**").permitAll()  // Allow public access
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable());  // Disable CSRF for API endpoints

        return http.build();
    }
}
