package org.spring.security.service;

import org.spring.security.Repo.UserRepo;
import org.spring.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }
}
