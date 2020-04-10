package com.example.demo.DAL;

import com.example.demo.entities.Action;
import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class UserDALImpl implements UserDAL {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<User> getAllUsers() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User getUserById(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.findOne(query, User.class);
    }

    @Override
    public void addNewUser(User user) {
        mongoTemplate.save(user);
    }


    @Override
    public void deleteById(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query, User.class);
    }
}
