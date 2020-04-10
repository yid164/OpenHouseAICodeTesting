package com.example.demo.DAL;

import com.example.demo.entities.Action;
import com.example.demo.entities.User;


import java.util.List;

public interface UserDAL {

    public List<User> findAllUsers();

    public User findUserById(String userId);

    public void addUser(User user);


    public void deleteById(String userId);

}
