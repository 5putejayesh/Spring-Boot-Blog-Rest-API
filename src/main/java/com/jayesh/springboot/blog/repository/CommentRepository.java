package com.jayesh.springboot.blog.repository;

import com.jayesh.springboot.blog.entity.Comment;
import com.jayesh.springboot.blog.payload.CommentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPostId(Long postId);
}
