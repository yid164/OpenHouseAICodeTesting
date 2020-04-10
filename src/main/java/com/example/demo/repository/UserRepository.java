package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for doing the Data Accessory Layer
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
