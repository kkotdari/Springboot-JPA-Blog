package com.kkot.blog.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {
    @Test
    public void hashEncode() {
        String encPassword = new BCryptPasswordEncoder().encode("1234");
        System.out.println("1234 해시: " + encPassword);
    }
}
