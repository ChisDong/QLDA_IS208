package com.hctt.is208.role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<roles, Integer>{
    roles findByName(String name);
}
