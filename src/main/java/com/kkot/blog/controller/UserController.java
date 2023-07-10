package com.kkot.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// 인증이 안된 사용자들이 출입할 수 있는 경로를 /auth/** 허용
// 그냥 주소가 / 이면 index.jsp 허용
// static 이하에 있는 /js/**, /css/**, /image/** 등 허용
@Controller
public class UserController {
    @GetMapping("/auth/join-form")
    public String joinForm(){
        return "user/join-form";
    }

    @GetMapping("/auth/login-form")
    public String loginForm(){
        return "user/login-form";
    }

    @GetMapping("/user/update-form")
    public String updateForm(){
        return "user/update-form";
    }
}
