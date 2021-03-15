package org.launchcode.spaday.models;

public class User {
//    11) Bonus mission - Add an id field to User, along with accessor methods (with appropriate access level).
private static int nextId = 1;
private int Id;




//   4) username, email, password. Creating the Model
//      Your User class should have a few private fields with getters and setters
    private String username;    //step 4a
    private String email;       //step 4a
    private String password;    //step 4a

    // Constructor --- not yet defined at step 4b
//    11.1) build the constructor
    public User() {
        Id = nextId;
        nextId++;
    }

    // Getters & Setters

    // 11.2) Getters & Setters -- step 12 is: Create a 3rd Pkdge dir in org.launchcode.spaday called "data"
    //          create a file in that data dir called UserData. this UserData file
    //          provides access to a list of users via add, getAll, and getById.

    public int getId() {
        return this.Id;
    }


    // step 4c -- generate Getters & Setters

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
