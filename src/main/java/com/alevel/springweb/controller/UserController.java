package com.alevel.springweb.controller;

import com.alevel.springweb.dto.User;
import com.alevel.springweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<User> getUsers(@RequestParam(required = false) String gender) {
        if (StringUtils.hasText(gender)){
            return userService.findByGender(gender);
        }
        return userService.getAll();
    }

    @PostMapping("users")
    public String create(@RequestBody User user) {
        userService.createUser(user);
        return "Created";
    }

    @PutMapping("users")
    public String update(@RequestBody User user) {
        userService.update(user);
        return "Created";
    }

    @DeleteMapping("users")
    public String deleter(@RequestParam String name) {
        userService.deleteUser(name);
        return "Deleted";
    }
}
