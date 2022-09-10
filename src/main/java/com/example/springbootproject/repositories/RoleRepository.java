package com.example.springbootproject.repositories;

import com.example.springbootproject.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
