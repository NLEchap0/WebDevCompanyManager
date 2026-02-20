package com.example.webdevcompanymanager.config;

import com.example.webdevcompanymanager.database.AdminUser;
import com.example.webdevcompanymanager.repository.AdminUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(AdminUserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            String superadmin = "superadmin";

            // Check if the super admin account doesn't exist
            if (repository.findByUsername(superadmin).isEmpty()) {
                AdminUser admin = new AdminUser();
                admin.setUsername(superadmin);

                String encodedPassword = passwordEncoder.encode(superadmin);
                admin.setPassword(encodedPassword);

                admin.setSuperadmin(true);

                repository.save(admin);
            }
        };
    }
}