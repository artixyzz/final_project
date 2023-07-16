package com.example.final_project.service;

import com.example.final_project.api.UserLoginData;
import com.example.final_project.model.User;

import java.util.Optional;

public interface UserLoginChecker {

    Optional<User> loginAndGet(UserLoginData userLoginData);
}
