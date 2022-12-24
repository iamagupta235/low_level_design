package org.example.splitwise;

import lombok.Getter;

public class User {
    @Getter
    String name, expandedName, email, mobile;
    @Getter
    int userId;

    private static int index = 0;

    public User(String name, String email, String mobile){
        this.userId = index++;
        this.expandedName = "User"+index;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}
