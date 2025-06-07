package com.hctt.is208.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<users, Integer>{
    users findByUsername(String username);
    users findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}