package com.demo.rtc.db;

public class UserVO {
    private String firstName;
    private String lastName;
    private String displayName;
    private String email;

    public UserVO(String firstName, String lastName, String displayName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }
}
