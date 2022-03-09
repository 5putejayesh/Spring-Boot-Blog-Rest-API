package com.jayesh.springboot.blog.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String body;
}
