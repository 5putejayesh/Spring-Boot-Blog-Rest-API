package com.jayesh.springboot.blog.service;

import com.jayesh.springboot.blog.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
}
