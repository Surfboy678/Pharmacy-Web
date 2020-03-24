package com.brodacki.janusz.pharmacy.user.model;

import com.brodacki.janusz.pharmacy.user.service.UserServiceImpl;
import com.brodacki.janusz.pharmacy.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/profile")
    public String profilePage(){
        String username = UserUtil.getLoggedUser();

        User user = userService.findUserByEmail(username);
        int numberRole = user.getRoles().iterator().next().getId();
        user.setNumberRole(numberRole);

        return "user is logged";
    }


}
