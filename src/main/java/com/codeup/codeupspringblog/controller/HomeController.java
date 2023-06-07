package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String landingPage(){
        return "This is a landing page";
    }
    @GetMapping("/home")
    public String home(){
        return "home";
    }

//    @GetMapping("/home/{name}")
//    public String homeName(@PathVariable String name, Model model){
//        model.addAttribute("name", name);
//
//        return "home";
//    }

    @GetMapping("/home/{user}")
    public String userPage(@PathVariable String user, Model model){
        Friend friend = new Friend(1, "Lily", 22);
        Friend friend2 = new Friend(2, "Jame", 18);
        Friend friend3 = new Friend(3, "Thomas", 30);
        List<Friend> friendsList = new ArrayList<>();
        friendsList.add(friend);
        friendsList.add(friend2);
        friendsList.add(friend3);

        model.addAttribute("user", user);
        model.addAttribute("friends", friendsList);
        return "home";
    }

    @GetMapping("/roll-dice")
    public String diceRoller(){
        return "dice/dice-roller";
    }

    @GetMapping("/roll-dice/{num}")
    public String diceResult(@PathVariable int num, Model model){
        Random random = new Random();
        int rando = random.nextInt(6) + 1;

        model.addAttribute("userNum", num);
        model.addAttribute("random", rando);
        return "dice/dice-result";
    }
}
