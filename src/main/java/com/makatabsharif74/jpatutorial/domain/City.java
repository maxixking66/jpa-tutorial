package com.makatabsharif74.jpatutorial.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = City.TABLE_NAME)
public class City {
    public static final String TABLE_NAME = "city";

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "c_id")
    private List<Address> addressList;

    public City() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }
}
