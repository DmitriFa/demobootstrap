package com.example.demoboot.controller;

import com.example.demoboot.entitiy.Role;
import com.example.demoboot.entitiy.User;
import com.example.demoboot.service.UserService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.*;

@RestController
 public class UserRestController {
    public UserRestController() {
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @DeleteMapping(value = "/admin")
    public void deleteUser(@RequestBody int id) {
        User user = userService.getUserById(id);
        userService.removeUser(user);
    }
    @PutMapping(value = "/admin")
    public void editUser(@RequestBody User user){

    /*   if ((role.length == 0) && (userService.checkEmail(user.getEmail()) || userService.getUserById(user.getId()).getEmail().equals(user.getEmail()))) {
            userService.updateUser(user);
        }
        if ((role.length != 0) && (userService.checkEmail(user.getEmail()) || userService.getUserById(user.getId()).getEmail().equals(user.getEmail()))) {
            if (role[0].equals("0")) {
                user.setRoles(Collections.singleton(new Role(1L, "ROLE_ADMIN")));
            }
            if (role[0].equals("1")) {
                user.setRoles(Collections.singleton(new Role(2L, "ROLE_USER")));
            }
            if (role[0].equals("2")) {
                Set<Role> roles = new HashSet<>();
                roles.add(new Role(1L, "ROLE_ADMIN"));
                roles.add(new Role(2L, "ROLE_USER"));
                user.setRoles(roles);
            }*/
             userService.updateUser(user);

       // }
    }
}
