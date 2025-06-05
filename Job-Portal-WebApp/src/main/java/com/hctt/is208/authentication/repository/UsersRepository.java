package com.hctt.is208.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hctt.is208.authentication.entity.users;

public interface UsersRepository extends JpaRepository<users, Integer>{
    users findByLoginName(String login_name);
    users findByEmail(String email);
    boolean existsByLoginName(String login_name);
    boolean existsByEmail(String email);
}