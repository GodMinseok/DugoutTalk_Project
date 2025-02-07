package org.example.dugouttalk.controller;

import org.example.dugouttalk.repository.UserRepository;
import org.example.dugouttalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // 회원가입 페이지 반환
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}
