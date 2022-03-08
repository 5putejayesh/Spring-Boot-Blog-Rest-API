package com.jayesh.springboot.blog.entity;

import javax.persistence.*;

@Entity
@Table(
        name = "posts", uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title"})
}
)
public class Post {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name="description",nullable = false)
    private String description;
    @Column(name = "content",nullable = false)
    private String content;
    
    //private Set<Comment> comments = new HashSet<>();
}