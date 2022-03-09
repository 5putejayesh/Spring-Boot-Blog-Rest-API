package com.jayesh.springboot.blog.repository;

import com.jayesh.springboot.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
