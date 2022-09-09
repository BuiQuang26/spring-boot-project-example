package com.example.springbootproject.repositories;

import com.example.springbootproject.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
