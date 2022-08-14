package com.facadecode.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static com.facadecode.spring.security.constant.SecurityConstants.*;
import static com.facadecode.spring.security.enums.PermissionEnum.*;
import static com.facadecode.spring.security.enums.RoleEnum.ADMIN;
import static com.facadecode.spring.security.enums.RoleEnum.INSTRUCTOR;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration
public class ApiSecurityConfig {
    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(auth -> auth
                        .antMatchers(GET, PUBLIC_API_LIST).permitAll()
                        // Role based access restrictions
                        .antMatchers(API_LIST_STUDENTS, API_LIST_INSTRUCTORS).hasRole(ADMIN.name())
                        .antMatchers(POST, API_CREATE_COURSES).hasRole(INSTRUCTOR.name())
                        // Permission based access restrictions
                        .antMatchers(API_UPDATE_COURSES).hasAuthority(UPDATE_COURSE.name())
                        .antMatchers(API_PLAY_COURSE).hasAuthority(PLAY_COURSE.name())
                        .antMatchers(API_VIEW_PROFILE).hasAuthority(VIEW_PROFILE.name())
                        .anyRequest().authenticated()
                )
                .httpBasic();
        return http.build();
    }
}
