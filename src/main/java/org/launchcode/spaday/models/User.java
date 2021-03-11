package org.launchcode.spaday.models;

public class User {
//   4) username, email, password. Creating the Model
//      Your User class should have a few private fields with getters and setters
    private String username;    //step 4a
    private String email;       //step 4a
    private String password;    //step 4a

    // Constructor --- not yet defined at step 4b

    // Getters & Setters    // step 4c -- generate Getters & Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
