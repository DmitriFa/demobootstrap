package com.example.demoboot.controller;

import com.example.demoboot.entitiy.Role;
import com.example.demoboot.entitiy.User;
import com.example.demoboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public void editUser(@RequestBody User[] user) {
        if (user[0].getRoles().size() == 0) {
            userService.updateUser(user[0]);
        } else {
          Set<Role> roles = userService.getUserById(user[0].getId()).getRoles();
            Set<Role> result = new HashSet<Role>();
            result.addAll(roles);
            result.addAll(user[0].getRoles());
            user[0].setRoles(result);
            userService.updateUser(user[0]);

        }
    }
}




