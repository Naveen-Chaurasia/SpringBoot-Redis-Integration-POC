package com.naveen.redispoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.naveen.redispoc.models.User;
import com.naveen.redispoc.repos.UserRepository;

@EnableCaching
@SpringBootApplication
public class RedisPocApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RedisPocApplication.class, args);
	}
	
	 private final Logger LOG = LoggerFactory.getLogger(getClass());
	  private final UserRepository userRepository;

	  @Autowired
	  public RedisPocApplication(UserRepository userRepository) {
	    this.userRepository = userRepository;
	  }


	@Override
	public void run(String... args) throws Exception {	
		
	    LOG.info("Saving users. Current user count is {}.", userRepository.count());
	    User shubham = new User("Shubham", 2000);
	    User pankaj = new User("Pankaj", 29000);
	    User lewis = new User("Lewis", 550);

	    userRepository.save(shubham);
	    userRepository.save(pankaj);
	    userRepository.save(lewis);
	    LOG.info("Done saving users. Data: {}.", userRepository.findAll());
		
	}

}
