package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogsRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Find all user logs
     * @return all user logs
     */
    public List<User> findAll(){
        return mongoTemplate.findAll(User.class);
    }

    /**
     * Add a user log
     * @param user user
     * @return user log
     */
    public User save(User user){
        mongoTemplate.save(user);
        return user;
    }

    /**
     * Find users by Id
     * @param userId id
     * @return a list of users
     */
    public List<User> findUserLogByUserId(String userId){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        return mongoTemplate.find(query, User.class);

    }

    /**
     *
     * @param userId
     * @param time
     * @return
     */
    public List<User> findUserLogByUserIdAndTime(String userId, String time){
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId).andOperator(Criteria.where("time").is(time)));
        return mongoTemplate.find(query, User.class);
    }

    /**
     *
     * @param time
     * @return
     */
    public List<User> findUserLogByTime(String time){
        Query query = new Query();
        query.fields().elemMatch("actions", Criteria.where("time").is(time));
        return mongoTemplate.find(query,User.class);
    }


    /**
     * Delete a user by userId
     * @param userId userId
     */
    public void deleteById(String userId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userId").is(userId));
        mongoTemplate.remove(query, User.class);
    }
}
