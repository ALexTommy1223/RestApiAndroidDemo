package com.example.fromcornytobro.model;

public class Auth {
    private int id;
    private String email;
    private String password;
    private String gender;
    private String homeTown;

    public Auth() {
    }

    public Auth(int id, String email, String password, String gender, String homeTown) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.homeTown = homeTown;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "Auth{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", homeTown='" + homeTown + '\'' +
                '}';
    }
}
