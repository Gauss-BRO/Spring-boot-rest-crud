package com.example.dao;


import com.example.models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        if (user.getPassword() != null) {
            user.setPassword(new BCryptPasswordEncoder(12).encode(user.getPassword()));
        }
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User updatedUser) {
        if (updatedUser.getPassword() != null) {
            updatedUser.setPassword(new BCryptPasswordEncoder(12).encode(updatedUser.getPassword()));
            entityManager.merge(updatedUser);
        }
    }

    @Override
    public void deleteUser(Long id) {

        entityManager.remove(getUser(id));
    }

    @Override
    public User getUserByName(String name) {
        return entityManager.createQuery(
                "SELECT u from User u WHERE u.email = :email", User.class).
                setParameter("email", name).getSingleResult();
    }
}
