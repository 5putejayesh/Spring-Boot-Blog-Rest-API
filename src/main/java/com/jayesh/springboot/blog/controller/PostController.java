package com.jayesh.springboot.blog.controller;

import com.jayesh.springboot.blog.entity.Post;
import com.jayesh.springboot.blog.payload.PostDto;
import com.jayesh.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }
}
