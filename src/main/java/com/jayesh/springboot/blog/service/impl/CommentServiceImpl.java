package com.jayesh.springboot.blog.service.impl;

import com.jayesh.springboot.blog.entity.Comment;
import com.jayesh.springboot.blog.payload.CommentDto;
import com.jayesh.springboot.blog.repository.CommentRepository;
import com.jayesh.springboot.blog.service.CommentService;
import org.modelmapper.ModelMapper;

public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapper mapper;

    public CommentServiceImpl(CommentRepository commentRepository,ModelMapper mapper){
        this.commentRepository=commentRepository;
        this.mapper=mapper;
    }
    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment=mapToEntity(commentDto);
        Comment savedComment = commentRepository.save(comment);
        return mapToDto(savedComment);
    }

    private Comment mapToEntity(CommentDto commentDto) {
        return mapper.map(commentDto,Comment.class);
    }
    private CommentDto mapToDto(Comment comment) {
        return mapper.map(comment,CommentDto.class);
    }
}
