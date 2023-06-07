package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }
    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "post/index";
    }
    @GetMapping("/posts/{id}")
    public String specificPost(@PathVariable long id, Model model){
        if (postDao.findById(id).isPresent()){
            Post post = postDao.findById(id).get();
            model.addAttribute("post", post);
            if (userDao.findById(post.getUser().getId()).isPresent()){
                User user = userDao.findById(post.getUser().getId()).get();
                model.addAttribute("user", user);
            } else {
                model.addAttribute("user", new User("", "no user found", ""));
            }
        }
        return "/post/show";
    }
    @GetMapping("/posts/create")
    public String createPost(){
        return "post/create";
    }
    @PostMapping("/posts/create")
    public String pCreatePost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body){
//        Post post = new Post(title, body, );
        if(userDao.findById(1L).isPresent()){
            User user = userDao.findById(1L).get();
            Post post = new Post(title, body, user);
            postDao.save(post);
        }
        return "redirect:/posts";
    }

}
