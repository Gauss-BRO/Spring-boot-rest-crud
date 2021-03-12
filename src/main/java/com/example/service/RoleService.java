package com.example.service;

import com.example.models.Role;
import java.util.List;

public interface RoleService {
    List<Role> listRoles();
    Role getRole(Long id);
    Role getRoleByName(String role);
}
