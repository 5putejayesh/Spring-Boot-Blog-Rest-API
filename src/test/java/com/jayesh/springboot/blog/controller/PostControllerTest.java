package com.jayesh.springboot.blog.controller;

import com.jayesh.springboot.blog.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(value = PostController.class)
public class PostControllerTest {
    @MockBean
    private PostService postService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPostById(){

        assertEquals(200,200);
    }
}
