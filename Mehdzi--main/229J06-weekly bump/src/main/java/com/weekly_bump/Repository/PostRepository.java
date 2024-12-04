package com.weekly_bump.Repository;

import com.weekly_bump.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    // Custom query to get the latest 5 posts ordered by creation date
    List<Post> findTop5ByOrderByCreatedDateDesc();
}
