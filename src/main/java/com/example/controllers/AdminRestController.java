package com.example.controllers;

import com.example.models.Role;
import com.example.models.User;
import com.example.service.RoleService;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminRestController {

    private final Logger LOG = LoggerFactory.getLogger(AdminUserController.class);
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminRestController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/admin/users")
    public List<User> getUsers(){
        return userService.getUserList();
    }

    @GetMapping("/admin/user/{id}")
    public User getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @GetMapping("admin/role")
    public List<Role> getRoles() {
        return roleService.listRoles();
    }

    @PostMapping("admin/user")
    public void creatUser(@RequestBody User user) {
       userService.saveUser(user);
    }

    @DeleteMapping("/admin/user/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }

    @PutMapping("/admin/user/{id}")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
