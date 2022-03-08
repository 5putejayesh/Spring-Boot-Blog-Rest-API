package com.jayesh.springboot.blog.service;

import com.jayesh.springboot.blog.entity.Post;
import com.jayesh.springboot.blog.payload.PostDto;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();
    PostDto createPost(PostDto postDto);
}
