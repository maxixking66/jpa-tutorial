package com.makatabsharif74.jpatutorial.service.dto;

public class UserBriefProjection {

    private Long id;

    private String firstName;

    private String lastName;

    public UserBriefProjection() {
    }

    public UserBriefProjection(Long id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public UserBriefProjection(Long id, String firsName, String lastName) {
        this.id = id;
        this.firstName = firsName;
        this.lastName = lastName;
    }

    public UserBriefProjection(String firsName, String lastName) {
        this.firstName = firsName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserBriefProjection{" +
                "id='" + id + '\'' +
                "firsName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
