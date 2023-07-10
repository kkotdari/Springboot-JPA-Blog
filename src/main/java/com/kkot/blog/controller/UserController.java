package com.kkot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user/join-form")
    public String joinForm(){
        return "user/join-form";
    }

    @GetMapping("/user/login-form")
    public String loginForm(){
        return "user/login-form";
    }
}
