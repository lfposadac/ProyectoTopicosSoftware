package com.AirTic.ClothesProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class CustomerClientsController {


    @GetMapping("/login")
    public String login() {
        return "CustomerClients/login";
    }

    @GetMapping("/req/signup")
    public String signup() {
        return "CustomerClients/signup";
    }
    
    
}