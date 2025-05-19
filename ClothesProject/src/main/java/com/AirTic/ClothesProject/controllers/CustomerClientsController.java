package com.AirTic.ClothesProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import com.AirTic.ClothesProject.models.CustomerClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.AirTic.ClothesProject.services.CustomerClientsService;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;



@Controller
public class CustomerClientsController {

    @Autowired
    private CustomerClientsService customerClientsService;

    @GetMapping("/login")
    public String login() {
        return "CustomerClients/login";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("customerClient", new CustomerClients());
        return "CustomerClients/signup";
    }

    @PostMapping("/signup")
    public String processSignupForm(@Valid @ModelAttribute("customerClient") CustomerClients customerClient, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if(result.hasErrors()) {
            return "CustomerClients/signup";
        }
        try {
            customerClientsService.registerCustomer(customerClient);
            redirectAttributes.addFlashAttribute("successMessage", "Registration successful! You can now log in.");
            return "redirect:/CustomerClients/login";
        } catch (RuntimeException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "CustomerClients/signup";
        }
    }


    
    
}