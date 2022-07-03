package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Controller
public class IndexController {

    private final UserService userService;
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public IndexController(UserService userService, PasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping(value ="/")
    public String openStartPage() {
        List<User> users = userService.findAllUsers();

        if (users.isEmpty()) {
            Role admin = new Role("ROLE_ADMIN");
            Role user = new Role("ROLE_USER");
            Collection<Role> adminRole = new HashSet<>();
            Collection<Role> userRole = new HashSet<>();
            Collection<Role> anyRole = new HashSet<>();
            adminRole.add(admin);
            userRole.add(user);
            anyRole.add(admin);
            anyRole.add(user);
            userService.addUser(new User("Maha", "Smirnova", 33, "admin", bCryptPasswordEncoder.encode("admin"), adminRole));
            userService.addUser(new User("Misha", "Krokodilov", 24, "user", bCryptPasswordEncoder.encode("user"), userRole));
            userService.addUser(new User("Dima", "Borisov", 18, "dimab", bCryptPasswordEncoder.encode("dimab"), userRole));
            userService.addUser(new User("Vasya", "Pupkin", 16, "vasyap", bCryptPasswordEncoder.encode("vasyap"), userRole));
            userService.addUser(new User("Kostya", "Gradov", 52, "kostyag", bCryptPasswordEncoder.encode("kostyag"), anyRole));
        }
        return "/index";
    }
}
