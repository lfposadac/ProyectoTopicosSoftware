package com.AirTic.ClothesProject.controllers;

import com.AirTic.ClothesProject.models.CustomerClients;
import com.AirTic.ClothesProject.services.CustomerClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CustomerClientsController {

    @Autowired
    private CustomerClientsService customerClientsService;

    @GetMapping("/login")
    public String login() {
        return "CustomerClients/login";
    }

    @GetMapping("/req/signup")
    public String signup() {
        return "CustomerClients/signup";
    }
    
    
}