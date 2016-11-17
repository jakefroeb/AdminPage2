package com.theironyard;

/**
 * Created by jakefroeb on 11/11/16.
 */
public class Users {
    private User[] users;

    public Users(User[] users) {
        this.users = users;
    }

    public Users() {
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }
}
