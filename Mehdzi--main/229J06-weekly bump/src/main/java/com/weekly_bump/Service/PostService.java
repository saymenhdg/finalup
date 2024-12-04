package com.weekly_bump.Service;

import com.weekly_bump.Model.Post;
import com.weekly_bump.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void savePost(Post post) {
        postRepository.save(post); // Save the post to the database
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll(); // Fetch all posts from the database
    }

    public Post getPostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.orElse(null); // Return the post if found, else return null
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId); // Delete the post by ID
    }
}
