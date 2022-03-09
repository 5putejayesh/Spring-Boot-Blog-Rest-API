package com.jayesh.springboot.blog.payload;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class CommentDto {
    private Long id;
    @NotEmpty(message = "Name shou;ld not be null or not empty")
    private String name;
    @NotEmpty(message = "Email should not be null or not empty")
    @Email
    private String email;
    @NotEmpty
    @Size(min=10,message = "comment body must be minimum of 10 characters")
    private String body;
}
