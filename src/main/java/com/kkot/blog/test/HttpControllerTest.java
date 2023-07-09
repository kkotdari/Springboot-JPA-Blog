package com.kkot.blog.test;

import org.springframework.web.bind.annotation.*;

// @RestController: 사용자의 요청에 Data를 응답하는 컨트롤러
@RestController
public class HttpControllerTest {
    @GetMapping("/http/get")
    public String getTest(){
        return "GET 요청";
    }

    @PostMapping("/http/post")
    public String postTest(){
        return "POST 요청";
    }

    @PutMapping("/http/put")
    public String putTest(){
        return "PUT 요청";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "DELETE 요청";
    }
}
