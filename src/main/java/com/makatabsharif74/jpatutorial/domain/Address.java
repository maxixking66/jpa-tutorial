package com.makatabsharif74.jpatutorial.domain;

import javax.persistence.*;

@Entity
@Table(name = Address.TABLE_NAME)
public class Address {

    public static final String TABLE_NAME = "address";

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String address;

    //    ManyToOne  : many address can have One city?
    @ManyToOne
    @JoinColumn(name = "c_id")
    private City city;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
