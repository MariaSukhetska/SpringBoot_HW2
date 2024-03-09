package com.example.SpringBoot_HW2.repository;

import com.example.SpringBoot_HW2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
