package com.makatabsharif74.jpatutorial.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    public static final String TABLE_NAME = "tbl_user";

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String IS_ACTIVE = "is_active";

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = FIRST_NAME)
    private String firstName;

    @Column(name = LAST_NAME)
    private String lastName;

    @Column(name = USERNAME, unique = true)
    private String username;

    @Column(name = PASSWORD, columnDefinition = "varchar(2048)")
    private String password;

    @Column(name = IS_ACTIVE, columnDefinition = "TINYINT(1)")
    private Boolean isActive;

    //    one user have one wallet
    @OneToOne
    private Wallet wallet;

    @ManyToMany(mappedBy = "users")
    private Set<Tag> tags = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName,
                String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
