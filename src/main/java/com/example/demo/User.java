package com.example.demo;

public class User {
    private String username;
    private String name;
    private String lastname;
    private String password;
    private String profession;
    public User() {

    }

    public User(String username, String name, String lastname, String password, String profession) {

        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.profession = profession;

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
        public String getProfession() {
        return profession;
    }
}