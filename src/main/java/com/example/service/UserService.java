package com.example.service;

import com.example.models.User;

import java.util.List;

public interface UserService {
    List<User> getUserList ();
    User getUser (Long id);
    void saveUser (User user);
    void updateUser (User updatedUser);
    void deleteUser (Long id);
}
