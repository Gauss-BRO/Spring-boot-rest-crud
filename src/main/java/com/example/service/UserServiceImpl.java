package com.example.service;


import com.example.dao.UserDao;
import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
        userDao.updateUser(id, updatedUser);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
