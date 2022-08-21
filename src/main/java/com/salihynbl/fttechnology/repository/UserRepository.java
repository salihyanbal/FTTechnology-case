package com.salihynbl.fttechnology.repository;

import com.salihynbl.fttechnology.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
