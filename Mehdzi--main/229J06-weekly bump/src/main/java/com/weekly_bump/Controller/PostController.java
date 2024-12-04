package com.weekly_bump.Controller;

import com.weekly_bump.Model.Post;
import com.weekly_bump.Model.User;
import com.weekly_bump.Service.PostService;
import com.weekly_bump.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/posts")
public class  PostController {

    private final PostService postService;
    private final UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    // List all posts (Accessible by everyone)
    @GetMapping
    public String listPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "post-list"; // A page that lists all posts
    }







}
