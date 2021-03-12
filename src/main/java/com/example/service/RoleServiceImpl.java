package com.example.service;


import com.example.dao.RoleDao;
import com.example.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    RoleDao roleDao;

    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }

    @Override
    public Role getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    public Role getRoleByName(String role) {
        return roleDao.getRoleByName(role);
    }
}
