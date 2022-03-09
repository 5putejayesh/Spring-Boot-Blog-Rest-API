package com.jayesh.springboot.blog.service;

import com.jayesh.springboot.blog.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto);
}
