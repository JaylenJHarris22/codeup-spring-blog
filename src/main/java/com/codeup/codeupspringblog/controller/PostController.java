package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }
    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "post/index";
    }
    @GetMapping("/posts/{id}")
    public String specificPost(@PathVariable long id, Model model){
        Post p1 = new Post("Cats", "Cats be cool");

        model.addAttribute("post", p1);
        return "/post/show";
    }
    @GetMapping("/posts/create")
    public String createPost(){
        return "post/create";
    }
    @PostMapping("/posts/create")
    public String pCreatePost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
        Post post = new Post(title, body);
        postDao.save(post);
        return "redirect:/posts";
    }

}
