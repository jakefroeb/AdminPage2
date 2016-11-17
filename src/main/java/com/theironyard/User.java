package com.theironyard;

/**
 * Created by jakefroeb on 11/11/16.
 */
public class User {
    private String email;
    private String name;
    private String password;
    private int id;

    public User(String email, String name, String password, int id) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.id = id;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
