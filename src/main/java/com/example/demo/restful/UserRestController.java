package com.example.demo.restful;

import com.example.demo.DAL.UserDAL;
import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class UserRestController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    private final UserRepository userRepository;

    public UserRestController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(value="/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable String userId){
        LOG.info("Getting user with ID: {}. ",userId);
//        return userRepository.findOne(userId);
        return null;
    }

    @PostMapping("/")
    public void addNewUser(@RequestBody User user){
        LOG.info("User saved");
        userRepository.save(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        LOG.info("Get all users");
        return userRepository.findAll();
    }

    @RequestMapping(value="/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String userId){
        LOG.info("Delete User");
        userRepository.deleteById(userId);
    }

}
