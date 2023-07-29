package com.example.final_project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Configuration
    @EnableWebSecurity
    public class SecurityConfiguration {

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            return http
                    .authorizeHttpRequests(request ->
                            request
                                    .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                                    .requestMatchers("/student/**").hasAuthority("ROLE_STUDENT")
                                    .requestMatchers("/professor/**").hasAuthority("ROLE_PROFESSOR")
                                    .anyRequest().authenticated()


                    )

                    .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                    .logout(LogoutConfigurer::permitAll)
                    .build();
        }



}
