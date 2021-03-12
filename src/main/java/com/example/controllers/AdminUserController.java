package com.example.controllers;

import com.example.models.Role;
import com.example.models.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/")
public class AdminUserController {

    private final UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminUserController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public String index(Model model) {
        model.addAttribute("users", userService.getUserList());
        return "index";
    }

    @GetMapping("/admin/users/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("users", userService.getUser(id));
        return "show";
    }

    @GetMapping("/admin/users/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleService.getRole(2L));
        user.setRoleSet(roleSet);
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/admin/users/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/admin/users";
    }

    @DeleteMapping("/admin/users/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
}
