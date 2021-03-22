package com.example.controllers;

import com.example.models.Role;
import com.example.models.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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

    @GetMapping("/admin")
    public String adminPage(Model model) {

        List<User> users = userService.getUserList();
        model.addAttribute("users", users);

        User user = new User();
        model.addAttribute("user", user);

        List<Role> rolesSet = roleService.listRoles();
        model.addAttribute("setRole", rolesSet);

        return "bootstrap/adminPage";
    }

    @PostMapping("/admin/save")
    public String create(@ModelAttribute("user") User user,
                         @RequestParam(required=false, name = "roles") String[] roles) {

        Set<Role> roleSet = user.getRoleSet();
        for (String roleId : roles) {
            roleSet.add(roleService.getRole(Long.valueOf(roleId)));
        }

        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/getUser")
    @ResponseBody
    public User getUser(long id) {
        return userService.getUser(id);
    }

    @PatchMapping("/admin/update")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(required=false, name = "roles") String[] roles) {
        Set<Role> roleSet = user.getRoleSet();
        for (String roleId : roles) {
            roleSet.add(roleService.getRole(Long.valueOf(roleId)));
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/delete")
    public String delete(@ModelAttribute("user") User user) {
        userService.deleteUser(user.getId());
        return "redirect:/admin";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "bootstrap/login";
    }
}
