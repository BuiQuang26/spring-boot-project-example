package com.example.springbootproject.services;

import com.example.springbootproject.domain.model.User;
import com.example.springbootproject.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User userPayload) {
       return userRepository.save(userPayload);
    }
}
