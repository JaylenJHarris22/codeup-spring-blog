package com.codeup.codeupspringblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    //Get req mapping for /test
    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "Hello Codeup";
    }
    @GetMapping("/parks")
    @ResponseBody
    public String parks(){
        return "<h1>Hello Nature!</h1>";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " + name;
    }
}
