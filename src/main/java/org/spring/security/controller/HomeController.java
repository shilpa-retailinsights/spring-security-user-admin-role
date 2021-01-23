package org.spring.security.controller;

import org.spring.security.Repo.UserRepo;
import org.spring.security.service.UserService;
import org.spring.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
 @Autowired
 private UserService userService;

 @Autowired
    UserRepo userRepo;

    @GetMapping({"/","/home"})
    public String home(){
        return "This is Home page!!";
    }
    @GetMapping("/admin")
    public String admin(){
        return "This is Admin page!!";
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userService.addUser(user);
    }

    @GetMapping("/adduser")
    public User getUser(){
        return userRepo.findById(1).get();
    }
}