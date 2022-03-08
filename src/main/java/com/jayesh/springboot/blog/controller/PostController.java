package com.jayesh.springboot.blog.controller;

import com.jayesh.springboot.blog.entity.Post;
import com.jayesh.springboot.blog.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService){
        this.postService=postService;
    }
    @GetMapping
    public List<Post> getAllPosts(){

        return postService.getAllPosts();
    }
}
