package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.Friend;
import com.codeup.codeupspringblog.repositories.FriendRepository;
import org.springframework.data.repository.query.Param;
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

    @GetMapping("/friend/insert")
    public String showForm(){
        return "friend/add-friend";
    }

    @PostMapping("/friend/insert")
    public String insert(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age){
        Friend friend = new Friend(name, age);
        friendDao.save(friend);
        return "redirect:http://localhost:8888/friends";
    }
}
