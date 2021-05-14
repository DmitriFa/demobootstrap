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
            user[0].setRoles(user[0].getRoles());
            userService.updateUser(user[0]);
    }

  @PostMapping(value = "/admin")
    public void addUser(@RequestBody User[] user) {
        user[0].setRoles(user[0].getRoles());
        userService.addUser(user[0]);
    }

   @GetMapping(value="/")
   public List<User> getUsers(){
       return userService.getAllUsers();
   }

}




