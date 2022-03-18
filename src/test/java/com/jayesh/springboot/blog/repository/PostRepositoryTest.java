package com.jayesh.springboot.blog.repository;

import com.jayesh.springboot.blog.entity.Post;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;

    private static Post post;
    private Post persist;
    @BeforeEach
    public void setup(){
        post=getPost();
    }
    @Test
    public void testSavePost_NotNull(){
         persist = postRepository.save(post);
        assertNotNull(persist.getId());
    }

    @Test
    public void testSavePost_equals(){
        Post savedPost = postRepository.save(post);
        Optional<Post> byId = postRepository.findById(savedPost.getId());
        assertEquals(savedPost,byId.get());
    }
    @Test
    public void testSavePost_sameTile(){
        Post post = postRepository.save(PostRepositoryTest.post);

        assertThrows(Exception.class,()->{
            postRepository.save(getPost());
        });
    }

    @Test
    public void testGetPostById_sameId(){
        Post savedPost = postRepository.save(post);
        
    }

    private Post getPost(){

         post = new Post();
        post.setTitle("Junit Test Post");
        post.setContent("Junit Test Post Content");
        post.setDescription("Junit Test Post Description");

        return post;
    }

    @AfterAll
    public static void cleanup(){
        post=null;
    }

}
