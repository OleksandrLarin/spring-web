package com.alevel.springweb.controller;

import com.alevel.springweb.dto.User;
import com.alevel.springweb.model.UserModel;
import com.alevel.springweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @GetMapping("view")
    public String getView(@RequestParam String name, Model model) {
        User user = userService.getByName(name);
        model.addAttribute("user", user);
        return "userView";
    }
}
