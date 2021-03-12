package com.example.dao;


import com.example.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery(
                "SELECT u from User u WHERE u.name = :name", User.class).
                setParameter("name", name).getSingleResult();
    }
}
