package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String index(Model model){
        List<Post> posts = new ArrayList<>();
        Post p1 = new Post("Cats", "Cats be cool");
        Post p2 = new Post("Dogs", "Dogs be cool");
        posts.add(p1);
        posts.add(p2);

        model.addAttribute("posts", posts);
        return "/post/index";
    }
    @GetMapping("/posts/{id}")
    public String specificPost(@PathVariable long id, Model model){
        Post p1 = new Post("Cats", "Cats be cool");

        model.addAttribute("post", p1);
        return "/post/show";
    }
    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "I make stuff";
    }
    @PostMapping("/posts/create/")
    @ResponseBody
    public String pCreatePost(){
        return "I post what was made";
    }

}
