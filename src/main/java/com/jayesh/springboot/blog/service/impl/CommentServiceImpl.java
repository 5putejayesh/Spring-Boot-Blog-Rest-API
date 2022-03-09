package com.jayesh.springboot.blog.service.impl;

import com.jayesh.springboot.blog.entity.Comment;
import com.jayesh.springboot.blog.entity.Post;
import com.jayesh.springboot.blog.exception.BlogApiException;
import com.jayesh.springboot.blog.exception.ResourceNotFoundException;
import com.jayesh.springboot.blog.payload.CommentDto;
import com.jayesh.springboot.blog.repository.CommentRepository;
import com.jayesh.springboot.blog.repository.PostRepository;
import com.jayesh.springboot.blog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;
    private ModelMapper mapper;

    public CommentServiceImpl(CommentRepository commentRepository,
                              PostRepository postRepository,
                              ModelMapper mapper){
        this.commentRepository=commentRepository;
        this.postRepository=postRepository;
        this.mapper=mapper;
    }
    @Override
    public CommentDto createComment(Long postId,CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId)
        );
        Comment comment=mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return mapToDto(savedComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long postId) {
        List<Comment> byPostId = commentRepository.findByPostId(postId);

        if(byPostId.isEmpty()){
            throw new BlogApiException(HttpStatus.BAD_REQUEST,
                    String.format("No comment for post %d", postId));
        }
        return  byPostId.stream().map(c->mapToDto(c)).collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId,Long commentId) {
        Comment comment = getComment(postId, commentId);
        return mapToDto(comment);
    }

    private Comment getComment(Long postId, Long commentId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", postId)
        );
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));
        if(!comment.getPost().getId().equals(post.getId())){
            throw new BlogApiException(HttpStatus.BAD_REQUEST,"Comment does not belong to post");
        }
        return comment;
    }

    private Comment mapToEntity(CommentDto commentDto) {
        return mapper.map(commentDto,Comment.class);
    }
    private CommentDto mapToDto(Comment comment) {
        return mapper.map(comment,CommentDto.class);
    }
}
