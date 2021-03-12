package com.example.dao;

import com.example.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> listRoles() {
        return entityManager.createQuery("FROM Role", Role.class).getResultList();
    }

    @Override
    public Role getRole(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role getRoleByName(String role) {
        return entityManager.createQuery(
                "SELECT r from Role r WHERE r.role = :role", Role.class).
                setParameter("role", role).getSingleResult();
    }
}
