package ru.kata.spring.boot_security.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value ="/admin")
    public String openStartPage(ModelMap model) {
        List<User> users = userService.findAllUsers();

        model.addAttribute("users", users);
        return "/admin";
    }

    @GetMapping("/admin/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/addUser";
    }

    @PostMapping("/admin")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String editUser(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.findUserById(id));
        return "editUser";
    }

//    @PatchMapping("/{id}")
//    public String updateUpdate(@ModelAttribute("user") User user, @PathVariable("id") long id) {
//        userService.updateUser(id, user);
//        return "redirect:/";
//    }

    @PutMapping("/admin/{id}")
    public String updateUpdate(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.removeUserById(id);
        return "/admin";
    }
}
