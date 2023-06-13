package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "post/create";
    }
    @PostMapping("/posts/create")
    public String pCreatePost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(user);
        postDao.save(post);
        emailService.prepareAndSend(post, "Post add", "We did it yay");
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id){
        Post post = postDao.findById(id).get();
        model.addAttribute("post", post);
        return "post/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String pEditPost(@ModelAttribute Post post){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postDao.save(post);
        return "redirect:/posts";
    }



}
