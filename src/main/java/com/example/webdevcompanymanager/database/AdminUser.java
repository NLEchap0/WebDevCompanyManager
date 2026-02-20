package com.example.webdevcompanymanager.database;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Boolean superadmin;
}