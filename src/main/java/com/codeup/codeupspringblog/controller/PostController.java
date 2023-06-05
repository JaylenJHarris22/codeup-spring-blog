package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "Ole glory";
    }
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String specificPost(@PathVariable long id){
        return "I'm specific " + id;
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
