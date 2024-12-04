package com.weekly_bump.Controller;

import com.weekly_bump.Model.Post;
import com.weekly_bump.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Post> posts = postService.getAllPosts(); // Fetch all posts from the database
        model.addAttribute("posts", posts); // Add posts to model
        return "home";  // Render the home page
    }

}
