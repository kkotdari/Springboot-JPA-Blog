package com.kkot.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Component-scan 을 위한 어노테이션
// Spring이 com.kkot.blog 패키지 이하를 스캔해서 @Component가 붙어있는 클래스 파일들을 new해서(Ioc) 스프링 컨테이너에 관리
// @Controller는 @Component를 상속한 어노테이션임
@RestController
public class BlogControllerTest {
    @GetMapping("/test/hello")
    public String hello(){
        System.out.println("BlogC.hello");
        return "<h1>hello spring boot</h1>";
    }
}
