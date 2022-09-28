package com.naveen.redispoc.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import com.naveen.redispoc.models.User;
import com.naveen.redispoc.repos.UserRepository;

@RestController
public class UserController {

  private final Logger LOG = LoggerFactory.getLogger(getClass());

  private final UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @SuppressWarnings("deprecation")
  @Cacheable(value = "users", key = "#userId", unless = "#result.followers < 12000")
  @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
  public User getUser(@PathVariable String userId) {
    LOG.info("Getting user with ID {}.", userId);
    return userRepository.getById(userId);
  }
  
  @CachePut(value = "users", key = "#user.id")
  @PutMapping("/update")
  public User updatePersonByID(@RequestBody User user) {
    userRepository.save(user);
    return user;
  }
}
