package com.example.service;

public class accountManagement {

    String username;
    String password;

    public accountManagement(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String enterPassword() {
        String newPassword = "";
        while (newPassword.length() >= 1) {
            //set new password to password from javafx scanner
            newPassword = " ";
        }
        return newPassword;
    }

    public String enterUsername() {
        String newUsername = "";
        boolean usernameTaken = true;
        while (!usernameTaken && newUsername.length() >= 1) {
            //set new username to username from javafx scanner
            newUsername = " ";
            //write SQL statement to see if the username is already in the database set to usernameTaken
            usernameTaken = false;
            if (!usernameTaken) {
                System.err.println("Username taken invalid");
            }
        }
        return newUsername;
    }

    public void writeData(String username, String password) {
        //SQL statement to see if username is in database set to usernameTaken
        boolean usernameTaken = false;
        if (!usernameTaken && username.length() >= 1) {
            //SQL statement to write username and password to database
            System.out.println("Added");
        } else {
            System.err.println("Username taken invalid");
        }
    }

    public void removeAccount(String username, String password) {
        //SQL statement to see if username exists
        boolean accountExists = true;
        //SQL statement to see if password is correct set to verifiedUser
        boolean verifiedUser = true;
        if (verifiedUser && accountExists) {
            //SQL statement to remove username and password from database
            System.out.println("Removed");
        } else {
            System.err.println("Not authenticated / wrong username");
        }
    }

}

