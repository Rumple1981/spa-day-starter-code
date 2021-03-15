
// step 12: Create a 3rd Pkdge dir in org.launchcode.spaday called "data"
        //          create a file in that data dir called UserData (that is this file).
        //          the UserData file provides access to a list of users via add, getAll, and getById.
        //          once complete for step 13 goto user/index.html
package org.launchcode.spaday.data;

import org.launchcode.spaday.models.User;

import java.util.ArrayList;


public class UserData {

//  12.1) provide access to a list of users. ie initialize an ArrayList variable called myUsers
    private static ArrayList<User> myUsers = new ArrayList<>();


//  12.2) create a method "addUser()" to add a user to the list
    public static void addUser(User user) {
        myUsers.add(user);
    }

//  12.3) create a method "getAll()" that gets the full list of user contained in the array
    public static ArrayList getAll() {
        return myUsers;
    }

//  12.3) create a method "getById()" that gets the full list of user contained in the array
    public static User getById(int id) {
        for(User user : myUsers) {
            if (user.getId() == id) return user;  // the == operator works here because two primitives are compared
            }
        // otherwise return no value
        return null;
    }
}
