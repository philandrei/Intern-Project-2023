package com.demo.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Phil Silla
 */
public class User {
    
    public User() {
        //empty
    }
    
    public String username;
    
    public String password;
    
    public Status status;
    
    public enum Status {
        ACTIVE, INACTIVE, DELETED
    }
    
    public boolean isActive() {
        return this.status.equals(Status.ACTIVE);
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }
    
}
