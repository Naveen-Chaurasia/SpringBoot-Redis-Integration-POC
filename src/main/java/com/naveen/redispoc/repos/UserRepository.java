package com.naveen.redispoc.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.redispoc.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> { }