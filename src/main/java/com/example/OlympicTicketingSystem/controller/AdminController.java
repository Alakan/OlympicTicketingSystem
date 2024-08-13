package com.example.OlympicTicketingSystem.controller;

import com.example.OlympicTicketingSystem.model.Admin;
import com.example.OlympicTicketingSystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Endpoint pour enregistrer un nouvel administrateur.
    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        Admin registeredAdmin = adminService.registerAdmin(admin);
        return ResponseEntity.status(201).body(registeredAdmin);
    }

    // Endpoint pour récupérer un administrateur par email.
    @GetMapping("/{email}")
    public ResponseEntity<Optional<Admin>> getAdminByEmail(@PathVariable String email) {
        Optional<Admin> admin = adminService.findAdminByEmail(email);
        if (admin.isPresent()) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour récupérer tous les administrateurs.
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminService.findAllAdmins();
        return ResponseEntity.ok(admins);
    }

    // Endpoint pour mettre à jour un administrateur par ID.
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        Optional<Admin> adminOptional = adminService.findAdminById(id);

        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            admin.setName(adminDetails.getName());
            admin.setEmail(adminDetails.getEmail());
            final Admin updatedAdmin = adminService.updateAdmin(admin);
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint pour supprimer un administrateur par ID.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        Optional<Admin> adminOptional = adminService.findAdminById(id);

        if (adminOptional.isPresent()) {
            adminService.deleteAdmin(adminOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
