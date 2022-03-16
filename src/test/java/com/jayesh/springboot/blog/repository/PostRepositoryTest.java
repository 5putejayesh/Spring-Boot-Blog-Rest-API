package com.jayesh.springboot.blog.repository;

import com.jayesh.springboot.blog.entity.Post;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class PostRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;
    @MockBean
    private PostRepository postRepository;

    @Test
    public void testSavePost(){

        Post post=getPost();
        Post persist = testEntityManager.persist(post);
        assertNotNull(persist.getId());
    }

    private Post getPost(){

        Post post = new Post();
        post.setTitle("Junit Test Post");
        post.setContent("Junit Test Post Content");
        post.setDescription("Junit Test Post Description");

        return post;
    }

}
