package com.hctt.is208.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hctt.is208.authentication.entity.roles;

public interface RolesRepository extends JpaRepository<roles, Integer>{
    roles findByName(String name);
}
