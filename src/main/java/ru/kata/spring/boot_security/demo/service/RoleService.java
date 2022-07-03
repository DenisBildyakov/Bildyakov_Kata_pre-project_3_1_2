package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

public interface RoleService {
    Role findBiId(int id);
    Role findByRole(String role);

    List<Role> findAllRoles();
}
