package com.AirTic.ClothesProject.controllers;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.AirTic.ClothesProject.models.CustomerClients;
import com.AirTic.ClothesProject.repositories.CustomerClientsRepository;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class CustomerClientsController {

    @Autowired
    private CustomerClientsRepository customerClientsRepository;

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("customerclient", new CustomerClients());
        return "CustomerClients/signup";
    }

    @PostMapping("/customerClient")
    public String saveCustomerClient(CustomerClients customerClients, RedirectAttributes redirectAttributes) {
        if(customerClients.getName() == null || customerClients.getName().isEmpty()
        || customerClients.getEmail() == null || customerClients.getEmail().isEmpty()
        || customerClients.getPassword() == null || customerClients.getPassword().isEmpty()) {
            throw new RuntimeException("Something went wrong when filling the gaps");
        }
        customerClientsRepository.save(customerClients);
        
        redirectAttributes.addFlashAttribute("message", "You registered succesfully!");
        
        return "redirect:/";
    }
    
    

}