package com.kkot.blog.controller.api;

import com.kkot.blog.dto.ResponseDTO;
import com.kkot.blog.model.RoleType;
import com.kkot.blog.model.User;
import com.kkot.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/auth/join-proc")
    public ResponseDTO<Integer> postUser(@RequestBody User user) {
        userService.join(user);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), 1); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson 라이브러리)
    }
}
