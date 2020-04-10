package com.example.demo.DAL;

import com.example.demo.entities.Action;
import com.example.demo.entities.User;


import java.util.List;

public interface UserDAL {

    public List<User> getAllUsers();

    public User getUserById(String userId);

    public void addNewUser(User user);


    public void deleteById(String userId);

}
