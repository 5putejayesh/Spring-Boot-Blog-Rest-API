package com.jayesh.springboot.blog.repository;

import com.jayesh.springboot.blog.entity.Post;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
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
        post=getPost("Junit Test Post","Junit Test Post","Junit Test Post");
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
            postRepository.save(getPost("Junit Test Post","Junit Test Post","Junit Test Post"));
        });
    }

    @Test
    public void testGetPostById_diffId(){
        Post savedPost = postRepository.save(post);
        Post post = postRepository.findById(savedPost.getId()).get();
        assertThrows(Exception.class,()->postRepository.findById(10L).get());
    }
    @Test
    public void testGetPostById_sameId(){
        Post savedPost = postRepository.save(post);
        Post post = postRepository.findById(savedPost.getId()).get();
        assertNotNull(post);
        assertEquals(savedPost.getId(),post.getId());
        assertDoesNotThrow(()->postRepository.findById(1L));
    }

    @Test
    public void testUpdatePost(){
        postRepository.save(post);
        Post savedPost = postRepository.findById(post.getId()).get();
        savedPost.setTitle("Post1");
        Post updPost = postRepository.save(savedPost);
        assertThat(updPost.getTitle()).isEqualTo("Post1");
    }
    @Test
    public void testDeletePOst(){

        //save post
        postRepository.save(post);

        //delete post
        postRepository.deleteById(post.getId());
        //retrieve post
        Optional<Post> byId = postRepository.findById(post.getId());
        assertThat(byId).isEmpty();
    }
    public void testFindAllPost(){

        List<Post> postList = getPosts();
        List<Post> saveAll = postRepository.saveAll(postList);
        assertThat(saveAll).isNotNull();
        assertThat(saveAll).isNotEmpty();
        assertThat(saveAll.size()).isEqualTo(2);
    }

    private Post getPost(String title,String content,String description){

         post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setDescription(description);

        return post;
    }



    private List<Post> getPosts(){
        return Arrays.asList(
                getPost("Junit Test Post","Junit Test Post","Junit Test Post"),
                getPost("Second Post","Second Post","Second Post")
        );
    }

    @AfterAll
    public static void cleanup(){
        post=null;
    }

}
