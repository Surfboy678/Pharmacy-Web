package com.brodacki.janusz.pharmacy.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ApplicationController {

    //@PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/process")
    public String processAuth(){
        return "processing...";
    }
}
