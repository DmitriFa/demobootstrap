package com.example.demoboot.controller;

import com.example.demoboot.entitiy.User;
import com.example.demoboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
 public class UserRestController {
    public UserRestController() {
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public List<String> showAllUsers() throws Exception {
        List<User> users = userService.getAllUsers();
        List<String> strings=new ArrayList<>();
        for (User user:users
        ) {
            strings.add( user.userToString());
        }
        return strings;
    }
    @DeleteMapping(value = "/admin")
    public void deleteUser(@RequestBody int id) {
        User user = userService.getUserById(id);
        userService.removeUser(user);

    }

}
