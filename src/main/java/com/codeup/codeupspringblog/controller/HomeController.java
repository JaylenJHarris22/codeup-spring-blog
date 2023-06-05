package com.codeup.codeupspringblog.controller;

import com.codeup.codeupspringblog.Friends;
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
        Friends friend = new Friends("Lily", 22);
        Friends friend2 = new Friends("Jame", 18);
        Friends friend3 = new Friends("Thomas", 30);
        List<Friends> friendsList = new ArrayList<>();
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
