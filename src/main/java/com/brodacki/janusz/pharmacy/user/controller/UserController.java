package com.brodacki.janusz.pharmacy.user.controller;


import com.brodacki.janusz.pharmacy.user.model.User;
import com.brodacki.janusz.pharmacy.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/register")
public class UserController {


    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(method = RequestMethod.POST, value = "user")
    public @ResponseBody
    ResponseEntity registerUser(@RequestBody User user){
        userService.saveUser(user);
       return null;

    }


}

