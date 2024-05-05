package com.example.service;

public class login {
    public String username;
    private String password;
    public boolean authenticated = false;

    public login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean validUsername(String username) {
//        SQL query to return sum of accounts with that matching username
        int numAccounts = 0;
        return numAccounts == 1;
    }

    public String retrievePassword(String username) {
        String databasePassword = null;
        if (validUsername(username)) {
//            SQL statement to retrieve password stored in database
            databasePassword = "password";
        }
        return databasePassword;
    }

    public boolean login(String username, String password) {
        if (retrievePassword(username).equals(password)) {
            System.out.print("Login successful");
            //Gui output login successful
            authenticated = true;
        }
        System.err.println("Login failed - check both credentials");
        //Gui output login not successful
        return authenticated;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
