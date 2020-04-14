package com.example.demo.restful;

import com.example.demo.entities.User;
import com.example.demo.repository.LogsRepository;
import com.example.demo.repository.UserRepository;
import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Restful controller for doing the POST, GET, and Delete
 */
@RestController
@RequestMapping(value = "/rest")
public class UserRestController {

    /**
     * Logs
     */
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    /**
     * UserRepository interface
     */
    //private final UserRepository userRepository;

    private final LogsRepository logsRepository;

    /**
     * Constructors
     * @param logsRepository
     */
    public UserRestController(LogsRepository logsRepository){
        this.logsRepository = logsRepository;
    }

    /**
     * GET request, get one user by id
     * @param userId id
     * @return user
     */
    @RequestMapping(value="/{userId}", method = RequestMethod.GET)
    public List<User> getUser(@PathVariable String userId){
        LOG.info("Getting user with ID: {}. ",userId);
        //return userRepository.findById(userId);
        return logsRepository.findUserLogByUserId(userId);
    }

    /**
     * POST request
     * @param user user
     * @return user
     */
    @RequestMapping(value="/", method = RequestMethod.POST)
    public User addNewUser(@RequestBody User user){
        LOG.info("User saved");
        //userRepository.save(user);
        logsRepository.save(user);
        return user;
    }

    /**
     * GET Request
     * @return all users
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        LOG.info("Get all users");
        //return userRepository.findAll();
        return logsRepository.findAll();
    }

    /**
     * DELETE Request
     * @param userId id
     * @return user and delete
     */
    @RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId){
        LOG.info("Delete User");
        //Optional user = userRepository.findById(userId);
        //userRepository.deleteById(userId);
        //return user;
        logsRepository.deleteById(userId);
    }

    @RequestMapping(value="/time/{time}", method = RequestMethod.GET)
    public List<User> getUsersByTime(@PathVariable String time){
        Log.info("GET user by time");
        return logsRepository.findUserLogByTime(time);
    }

}
