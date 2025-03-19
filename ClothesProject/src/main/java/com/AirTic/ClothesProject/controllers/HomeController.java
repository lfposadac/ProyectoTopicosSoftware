package com.AirTic.ClothesProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index"; // Asegúrate de tener src/main/resources/templates/index.html
    }
}
