package com.jayesh.springboot.blog.service;

import com.jayesh.springboot.blog.payload.PostDto;

import java.util.List;

public interface PostService {

    List<PostDto> getAllPosts();
    PostDto createPost(PostDto postDto);
    PostDto getPostById(Long postId);
    PostDto updatePostById(PostDto postDto, Long postId);
    void deletePostById(Long postId);
}
