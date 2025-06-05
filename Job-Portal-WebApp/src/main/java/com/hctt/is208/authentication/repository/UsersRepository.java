package com.hctt.is208.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hctt.is208.authentication.entity.users;

public interface UsersRepository extends JpaRepository<users, Integer>{
    users findByUsername(String username);
    users findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}