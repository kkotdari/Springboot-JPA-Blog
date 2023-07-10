package com.kkot.blog.controller.api;

import com.kkot.blog.dto.ResponseDTO;
import com.kkot.blog.model.RoleType;
import com.kkot.blog.model.User;
import com.kkot.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {
    @Autowired
    private UserService userService;

    @PostMapping("api/user")
    public ResponseDTO<Integer> postUser(@RequestBody User user){
        user.setRole(RoleType.USER);
        int result = userService.join(user);
        return new ResponseDTO<Integer>(HttpStatus.OK.value(), result); // 자바오브젝트를 JSON으로 변환해서 리턴 (Jackson 라이브러리)
    }
}
