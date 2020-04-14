package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;


@Repository
public class LogsRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public LogsRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

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
     * Check out the userId in a range of time
     * @param userId String
     * @param start Date
     * @param end Date
     * @return users
     */
    public List<User> findUserLogByUserIdAndTime(String userId, Date start, Date end){
        Criteria criteria = Criteria.where("actions.time").gte(start).and("actions.time").lte(end).and("userId").is(userId);
        TypedAggregation<User> aggregation = newAggregation(User.class,
                match(criteria));
        AggregationResults<User> results = mongoTemplate.aggregate(aggregation, User.class);
        return results.getMappedResults();
    }


    /**
     * Check out all the users in a range of time
     * @param start Date
     * @param end Date
     * @return users
     */
    public List<User> findUsersLogByTimeRange(Date start, Date end){
        Criteria criteria = Criteria.where("actions.time").gte(start).and("actions.time").lte(end).and("userId").ne(null);
        TypedAggregation<User> aggregation = newAggregation(User.class,
                match(criteria));
        AggregationResults<User> results = mongoTemplate.aggregate(aggregation, User.class);
        return results.getMappedResults();
    }

    /**
     * Find all typed users
     * @return users
     */
    public List<User> findAllTypedUsers(){
        Criteria criteria = Criteria.where("actions.type").ne(null).and("userId").ne(null);
        TypedAggregation<User> aggregation = newAggregation(User.class,
                match(criteria));
        AggregationResults<User> results = mongoTemplate.aggregate(aggregation, User.class);
        return results.getMappedResults();

    }

    /**
     * Find typed user in a specific type
     * @param type type
     * @return users
     */
    public List<User> findUserLogByType(String type){
        Criteria criteria = Criteria.where("actions.type").is(type).and("userId").ne(null);
        TypedAggregation<User> aggregation = newAggregation(User.class,
                match(criteria));
        AggregationResults<User> results = mongoTemplate.aggregate(aggregation, User.class);
        return results.getMappedResults();
    }

    /**
     * Find typed users in a specific type and userId
     * @param userId userId
     * @param type  type
     * @return users
     */
    public List<User> findUserLogByIdAndType(String userId, String type){
        Criteria criteria = Criteria.where("actions.type").is(type).and("userId").is(userId);
        TypedAggregation<User> aggregation = newAggregation(User.class,
                match(criteria));
        AggregationResults<User> results = mongoTemplate.aggregate(aggregation, User.class);
        return results.getMappedResults();
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
