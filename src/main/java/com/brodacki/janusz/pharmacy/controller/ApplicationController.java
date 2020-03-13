package com.brodacki.janusz.pharmacy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class ApplicationController {

    @RequestMapping("/process")
    public String processAuth(){
        return "processing...";
    }
}
