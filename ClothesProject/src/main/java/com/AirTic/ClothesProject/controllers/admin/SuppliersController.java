package com.AirTic.ClothesProject.controllers.admin;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.AirTic.ClothesProject.models.Suppliers;
import com.AirTic.ClothesProject.repositories.SuppliersRepository;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class SuppliersController {
    
    @Autowired
    private SuppliersRepository suppliersRepository;

    @GetMapping("/suppliers")
    public String index(Model model) {
        List<Suppliers> suppliers = suppliersRepository.findAll();
        //model.addAttribute("title", "Suppliers");
        //model.addAttribute("subtitle", "List of suppliers");
        model.addAttribute("suppliers", suppliers);
        return "suppliers/showlist";
    }

    @GetMapping("/suppliers/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Suppliers suppliers = suppliersRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
        model.addAttribute("title", suppliers.getName());
        model.addAttribute("subtitle", suppliers.getName() + " - Personal information");
        model.addAttribute("suppliers", suppliers);
        return "suppliers/show";
    }

    @GetMapping("/suppliers/create")
    public String createSupplierForm(Model model) {
        model.addAttribute("suppliers", new Suppliers());
        return "suppliers/create";
    }

    @PostMapping("/suppliers")
    public String save(Suppliers suppliers, RedirectAttributes redirectAttributes) {
        if(suppliers.getName() == null || suppliers.getName().isEmpty()
        || suppliers.getEmail() == null || suppliers.getEmail().isEmpty()
        || suppliers.getDirection() == null || suppliers.getDirection().isEmpty()
        || suppliers.getPhoneNumber() == null || suppliers.getPhoneNumber().isEmpty()) {
            throw new RuntimeException("I feel like... Something went wrong lil bro :(");
        }
        suppliersRepository.save(suppliers);
        
        redirectAttributes.addFlashAttribute("message", "¡The creation of this supplier was SUCCESFUL!");
        return "redirect:/suppliers";
    }

    @DeleteMapping("/suppliers/{id}")
    public String deleteSupplier(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        suppliersRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Supplier deleted ¡SUCCESFULLY!");
        return "redirect:/suppliers";
    }
    
    
}
