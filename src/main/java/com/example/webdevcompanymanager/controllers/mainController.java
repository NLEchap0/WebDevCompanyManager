package com.example.webdevcompanymanager.controllers;

import com.example.webdevcompanymanager.database.AdminUser;
import com.example.webdevcompanymanager.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class mainController {
    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String homePage(Model model, Authentication authentication) {
        model.addAttribute("listaAdmin", adminUserRepository.findAll());

        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            if (username.equals("superadmin")) {
                AdminUser admin = adminUserRepository.findByUsername("superadmin").orElse(null);
                String password = admin.getPassword();
                if (admin != null && passwordEncoder.matches("superadmin", password)) {
                    model.addAttribute("mustChangePassword", true);
                }
            }
        }

        return "homePage";
    }

    @PostMapping("/account/change-default-password")
    public String changeDefaultPassword(@RequestParam String newPassword, Authentication authentication) {
        if (authentication != null) {
            AdminUser admin = adminUserRepository.findByUsername(authentication.getName()).orElse(null);
            if (admin != null) {
                admin.setPassword(passwordEncoder.encode(newPassword));
                adminUserRepository.save(admin);
            }
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";
    }
}
