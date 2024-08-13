package com.example.OlympicTicketingSystem.controller;

import com.example.OlympicTicketingSystem.model.Admin;
import com.example.OlympicTicketingSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Endpoint pour enregistrer un nouvel administrateur
    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.registerAdmin(admin);
    }

    // Endpoint pour récupérer un administrateur par email
    @GetMapping("/{email}")
    public Optional<Admin> getAdminByEmail(@PathVariable String email) {
        return adminService.findAdminByEmail(email);
    }

    // Autres endpoints pour la gestion des administrateurs...
}