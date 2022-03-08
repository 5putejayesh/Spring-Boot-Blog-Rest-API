package com.jayesh.springboot.blog.repository;

import com.jayesh.springboot.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
