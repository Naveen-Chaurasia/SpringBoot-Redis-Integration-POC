package com.naveen.redispoc.controllers;
import org.junit.Test;
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
  public User getUser(@PathVariable Long userId) {
    LOG.info("Getting user with ID {}.", userId);
    //return userRepository.getReferenceById(userId);
    return userRepository.findById(userId).get();
  }
  

  @CachePut(value = "users", key = "#user.id")
  @PutMapping("/update")
  public User updatePersonByID(@RequestBody User user) {
    userRepository.save(user);
    return user;
  }
  
//Both findById() and getOne() methods are used to retrieve an object from underlying datastore. But the underlying mechanism
//for retrieving records is different for both these methods, infact getOne() is lazy operation which does not even hit the database.
//https://www.javacodemonk.com/difference-between-getone-and-findbyid-in-spring-data-jpa-3a96c3ff

  
  
  
  
  
//  @Test
//  void
//  givenRedisCaching_whenFindUserById_thenUserReturnedFromCache() {
//     
//
//     User UserNotFromCache = userRepository.getUserById(id);
//     User UserFromCache = userRepository.getUserById(id);
//
//     assertThat(UserNotFromCache).isEqualTo(User);
//     assertThat(UserFromCache).isEqualTo(User);
//
//     verify(mockUserRepository, times(1)).findById(id);
//     assertThat(UserFromCache()).isEqualTo(User);
//  }
  
  
  
}
