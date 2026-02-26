package com.example.webdevcompanymanager.repository;

import com.example.webdevcompanymanager.database.ShowOnlyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowOnlyUserRepository extends JpaRepository<ShowOnlyUser, Long> {
}