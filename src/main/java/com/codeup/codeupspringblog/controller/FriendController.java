package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.models.Friend;
import com.codeup.codeupspringblog.repositories.FriendRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FriendController {
    private final FriendRepository friendDao;

    public FriendController(FriendRepository friendDao){
        this.friendDao = friendDao;
    }

    @GetMapping("/friends")
    public String index(Model model){
        model.addAttribute("friends", friendDao.findAll());
        return "friend/index";
    }

    @PostMapping("/friend/add")
    public void showForm(){

    }

}
