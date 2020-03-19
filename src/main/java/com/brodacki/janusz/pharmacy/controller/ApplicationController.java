package com.brodacki.janusz.pharmacy.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping("/")
    public String processAuth(){
        return "process";
    }
}
