package com.jayesh.springboot.blog.service.impl;

import com.jayesh.springboot.blog.entity.Post;
import com.jayesh.springboot.blog.repository.PostRepository;
import com.jayesh.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository=postRepository;
    }
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
