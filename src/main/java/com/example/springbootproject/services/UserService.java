package com.example.springbootproject.services;

import com.example.springbootproject.domain.exception.RoleNotFoundException;
import com.example.springbootproject.domain.exception.UserNotFoundException;
import com.example.springbootproject.domain.model.Role;
import com.example.springbootproject.domain.model.User;
import com.example.springbootproject.repositories.RoleRepository;
import com.example.springbootproject.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User userPayload) {
        userPayload.setPassword(passwordEncoder.encode(userPayload.getPassword()));
        return userRepository.save(userPayload);
    }

    public User addRole(Long id, String role) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        Role r = roleRepository.findById(role).orElseThrow(RoleNotFoundException::new);
        user.addRole(r);
        return userRepository.save(user);
    }

    public User removeRole(Long id, String role) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        Role r = roleRepository.findById(role).orElseThrow(RoleNotFoundException::new);
        user.removeRole(r);
        return userRepository.save(user);
    }

    public Page<User> getAll(Integer pageNumber, Integer pageSize) {
        if(pageNumber == null) pageNumber = 0;
        if(pageSize == null) pageSize = 100;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userRepository.findAll(pageable);
    }
}
