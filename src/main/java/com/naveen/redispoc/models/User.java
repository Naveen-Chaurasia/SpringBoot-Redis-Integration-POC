package com.naveen.redispoc.models;

import javax.persistence.*;

import javax.persistence.Id;

import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private long followers;

    public User() {
    }

    public User(String name, long followers) {
        this.name = name;
        this.followers = followers;
    }

    //standard getters and setters

    @Override
    public String toString() {
        return String.format("User{id=%d, name='%s', followers=%d}", id, name, followers);
    }
}