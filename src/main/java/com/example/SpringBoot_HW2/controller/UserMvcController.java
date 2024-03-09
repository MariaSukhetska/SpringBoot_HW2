package com.example.SpringBoot_HW2.controller;

import com.example.SpringBoot_HW2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
public class UserMvcController {
    private final UserService userService;

    @GetMapping("/users")
    public ModelAndView showUsersPage() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }
}
