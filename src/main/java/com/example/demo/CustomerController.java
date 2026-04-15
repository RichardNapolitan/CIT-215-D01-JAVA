package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    @GetMapping("/")
    public String listCustomers(Model model) {
        model.addAttribute("customers", repo.findAll());
        model.addAttribute("customer", new Customer());
        return "index";
    }

    @PostMapping("/create")
    public String addCustomer(@ModelAttribute Customer customer) {
        System.out.println("Saving customer: " + customer);
        repo.save(customer);
        return "redirect:/";
    }
}