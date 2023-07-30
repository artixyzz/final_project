package com.example.final_project.service;

import com.example.final_project.dto.CourseDto;
import com.example.final_project.dto.RequestCourseDto;
import com.example.final_project.model.Course;
import com.example.final_project.model.Subject;
import com.example.final_project.reposiroty.CourseRepository;
import com.example.final_project.reposiroty.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.final_project.model.User;


import java.util.List;
import java.util.Optional;

@Service
@NonNull
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> optionalAppUser = userRepository.findByEmail(username);
        return optionalAppUser.orElseThrow(() -> new UsernameNotFoundException("Not valid username or password!"));
    }

    public void registerForCourse(long courseId){
        User currentUser = getCurrentUser();
        User dataBaseUser = userRepository.findById(currentUser.getId()).get();
        courseRepository.findById(courseId).ifPresent(course ->dataBaseUser.getUserCourses().add(course));
        userRepository.save(dataBaseUser);
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
         return (User) authentication.getPrincipal();
    }
}
