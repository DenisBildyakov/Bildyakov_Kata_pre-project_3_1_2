package ru.kata.spring.boot_security.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findBiId(int id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public List<Role> findAllRoles() {
        return roleRepository.findAll(Sort.by(Sort.Direction.ASC, "role"));
    }


}
