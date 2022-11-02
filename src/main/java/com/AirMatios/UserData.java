package com.AirMatios;

import org.springframework.data.annotation.Id;

public class UserData {

    @Id
    private final String login;
    private String firstName;
    private String lastName;

    UserData(String login){
        this.login=login;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
