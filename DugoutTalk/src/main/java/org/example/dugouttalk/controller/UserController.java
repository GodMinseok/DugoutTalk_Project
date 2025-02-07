package org.example.dugouttalk.controller;

import org.example.dugouttalk.entity.User;
import org.example.dugouttalk.repository.UserRepository;
import org.example.dugouttalk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // 메인 페이지 반환
    @GetMapping("/")
    public String main() {
        return "main";
    }

    // 회원가입 페이지 반환
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute User user) {
        // 유저 아이디 중복 확인
        if (userRepository.findByUserId(user.getUserId()) != null) {
            return "redirect:/signup?error=id"; // 에러 메시지를 포함한 리다이렉트
        }

        // 유저 패스워드 중복 확인
        if (userRepository.findByPassword(user.getPassword()) != null) {
            return "redirect:/signup?error=id";
        }

        // 유저 이메일 중복 확인
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return "redirect:/signup?error=id";
        }

        // 유저 닉네임 확인
        if (userRepository.findByNickname(user.getNickname()) != null) {
            return "redirect:/signup?error=id";
        }

        // 중복이 없으면 회원가입 진행
        userRepository.save(user);

        // 회원 가입 성공시 메인으로 리다이렉트
        return "main";
    }
}
