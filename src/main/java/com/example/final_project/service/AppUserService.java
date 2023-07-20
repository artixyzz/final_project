package com.example.final_project.service;

import com.example.final_project.reposiroty.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.final_project.model.User;


import java.util.Optional;

@Service
public class AppUserService implements UserDetailsService {
    private final UserRepository userRepository;

    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> optionalAppUser = userRepository.findByEmail(username);
        return optionalAppUser.orElseThrow(() -> new UsernameNotFoundException("Not valid username or password!"));
    }


}
