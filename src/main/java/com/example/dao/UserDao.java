package com.example.dao;


import com.example.models.User;
import java.util.List;

public interface UserDao {
    List<User> getUserList ();
    User getUser (Long id);
    void saveUser (User user);
    void updateUser (User updatedUser);
    void deleteUser (Long id);
    User getUserByName(String name);
}
