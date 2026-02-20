package com.example.webdevcompanymanager.database;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ShowOnlyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String city;
    private LocalDate birthday;
    private String gender;
    private String role;
}