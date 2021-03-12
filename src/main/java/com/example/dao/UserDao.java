package com.example.dao;


import com.example.models.User;
import java.util.List;

public interface UserDao {
    List<User> getUserList ();
    User getUser (int id);
    void saveUser (User user);
    void updateUser (int id, User updatedUser);
    void deleteUser (int id);
    User getUserByName(String name);
}
