package com.kkot.blog.service;

import com.kkot.blog.model.RoleType;
import com.kkot.blog.model.User;
import com.kkot.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void join(User user){
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword); // password를 해시 암호화
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        userRepository.save(user);
    }
}
