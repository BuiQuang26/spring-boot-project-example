package com.example.springbootproject.repositories;

import com.example.springbootproject.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
