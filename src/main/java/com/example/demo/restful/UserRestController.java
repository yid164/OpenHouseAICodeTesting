package com.example.demo.restful;

import com.example.demo.entities.User;
import com.example.demo.repository.LogsRepository;
import com.oracle.tools.packager.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

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
     * @param logsRepository for the interface
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
     */
    @RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId){
        LOG.info("Delete User");
        //Optional user = userRepository.findById(userId);
        //userRepository.deleteById(userId);
        //return user;
        logsRepository.deleteById(userId);
    }

    /**
     * GET all users in a range of time
     * @param start time
     * @param end   time
     * @return users
     */
    @RequestMapping(value="/time/{start}/{end}", method = RequestMethod.GET)
    public List<User> getUsersByTimeRange(@PathVariable Date start, @PathVariable Date end){
        Log.info("GET users by time range");
        return logsRepository.findUsersLogByTimeRange(start, end);
    }

    /**
     * GET user in a range of time by the ID
     * @param start time
     * @param end time
     * @param userId userId
     * @return user log
     */
    @RequestMapping(value="/time/{start}/{end}/{userId}", method = RequestMethod.GET)
    public List<User> getUsersByTimeRange(@PathVariable Date start, @PathVariable Date end, @PathVariable String userId){
        Log.info("GET users by time range and id");
        return logsRepository.findUserLogByUserIdAndTime(userId, start, end);
    }

    /**
     * Get all typed users
     * @return typed users
     */
    @RequestMapping(value = "/type", method = RequestMethod.GET)
    public List<User> getsAllTypeUsers(){
        Log.info("GET all typed users");
        return logsRepository.findAllTypedUsers();
    }

    /**
     * Get all users for a specific type
     * @param type the specific type
     * @return users
     */
    @RequestMapping(value = "/type/{type}", method = RequestMethod.GET)
    public List<User> getsTypeUsers(@PathVariable String type){
        Log.info("GET the typed users");
        return logsRepository.findUserLogByType(type);
    }

    /**
     * Get all users for a specific types and userId
     * @param type String type
     * @param userId String userId
     * @return users
     */
    @RequestMapping(value = "/type/{type}/{userId}", method = RequestMethod.GET)
    public List<User> getsTypeIdUsers(@PathVariable String type, @PathVariable String userId){
        Log.info("GET the typed users");
        return logsRepository.findUserLogByIdAndType(userId, type);
    }

}
