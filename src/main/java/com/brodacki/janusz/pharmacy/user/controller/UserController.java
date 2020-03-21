package com.brodacki.janusz.pharmacy.user.controller;

import com.brodacki.janusz.pharmacy.user.model.Role;
import com.brodacki.janusz.pharmacy.user.model.User;
import com.brodacki.janusz.pharmacy.user.repository.RoleRepository;
import com.brodacki.janusz.pharmacy.user.repository.UserRepository;
import com.brodacki.janusz.pharmacy.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/register")
public class UserController {

    private static final String ROLE_ADMIN = "ROLE_ADMIN";

    @Autowired
    private UserServiceImpl userService;


    @PostMapping("/user/add")
    public String addedUserByAdmin(@RequestBody User user){
        userService.saveUser(user);
        return "user added successful...";
    }

}

