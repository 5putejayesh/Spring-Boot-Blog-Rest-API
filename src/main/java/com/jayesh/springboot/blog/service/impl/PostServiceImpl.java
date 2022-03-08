package com.jayesh.springboot.blog.service.impl;

import com.jayesh.springboot.blog.entity.Post;
import com.jayesh.springboot.blog.payload.PostDto;
import com.jayesh.springboot.blog.repository.PostRepository;
import com.jayesh.springboot.blog.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper mapper;

    public PostServiceImpl(PostRepository postRepository,ModelMapper mapper){
        this.postRepository=postRepository;
        this.mapper=mapper;
    }
    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //convert DTO to entity
        Post post=mapToEntity(postDto);
        return mapToDto(postRepository.save(post));
    }

    private Post mapToEntity(PostDto postDto) {
        return mapper.map(postDto,Post.class);
    }

    private PostDto mapToDto(Post post){
        return mapper.map(post,PostDto.class);
    }
}
