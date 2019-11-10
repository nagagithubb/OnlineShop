/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

/**
 *
 * @author holah
 */
public class User {

    public User() {
    }
    
    public User(String UserId, String Password) {
        this.UserId = UserId;
        this.Password = Password;
    }
    
        private String UserId;

    /**
     * Get the value of UserId
     *
     * @return the value of UserId
     */
    public String getUserId() {
        return UserId;
    }

    /**
     * Set the value of UserId
     *
     * @param UserId new value of UserId
     */
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    private String Password;

    /**
     * Get the value of Password
     *
     * @return the value of Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Set the value of Password
     *
     * @param Password new value of Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

}
