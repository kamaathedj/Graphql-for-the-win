package com.kamaathedj.Graphql.model;

public class LoginUser{
    public String username;
    public String password;
    public boolean isAdmin;

    public LoginUser(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public LoginUser(LoginUser user) {
        this.username = user.username;
        this.password = user.password;
        this.isAdmin = user.isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}


