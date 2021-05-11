package com.example.demoboot.controller;

import com.example.demoboot.entitiy.Role;
import com.example.demoboot.entitiy.User;
import com.example.demoboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class UserController {
    public UserController() {
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


   @GetMapping(value = "/admin")
    public String showAllUser(ModelMap model) throws Exception {
   //     model.addAttribute("messages", userService.getAllUsers());
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("message", user);
       // model.addAttribute("msg",userService.getUserById(id));
       return "users";
    }

    @GetMapping(value = "/user")
    public String seeUser(ModelMap model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("messages", user);
        return "user";
    }


}
