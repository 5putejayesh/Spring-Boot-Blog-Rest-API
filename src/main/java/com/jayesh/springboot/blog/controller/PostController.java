package com.jayesh.springboot.blog.controller;

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
    public List<PostDto> getAllPosts(){

        return postService.getAllPosts();
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPOstById(@PathVariable(name="postId") Long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePostByID(@RequestBody PostDto postDto,@PathVariable(name="postId") Long postId){
        return new ResponseEntity<>(postService.updatePostById(postDto,postId),HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deleteById(@PathVariable(name="postId") Long postId){
        postService.deletePostById(postId);
        return new ResponseEntity<>("POst Deleted",HttpStatus.OK);
    }
}
