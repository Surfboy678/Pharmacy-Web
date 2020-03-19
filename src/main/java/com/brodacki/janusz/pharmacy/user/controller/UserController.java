package com.brodacki.janusz.pharmacy.user.controller;

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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/user/add")
    public String addedUserByAdmin(@RequestBody User user){
        String pwd = user.getPassword();
        String encryptPwd = bCryptPasswordEncoder.encode(pwd);
        user.setPassword(encryptPwd);
        user.setActive(1);
        // Role role = roleRepository.findByRole("ROLE_USER");
        //user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);
        return "user added successful...";
    }
    @PostMapping("/adduser")
    public void register(@RequestBody User user){
        // User existEmail = userService.findUserByEmail(user.getEmail());

        // if (existEmail != null) {
        userService.saveUser(user);
        //  }
        //return "success";

    }

}

