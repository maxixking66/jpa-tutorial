package com.makatabsharif74.jpatutorial.domain;

import com.makatabsharif74.jpatutorial.base.domain.BaseEntity;
import com.makatabsharif74.jpatutorial.domain.embedables.BankInfo;
import com.makatabsharif74.jpatutorial.domain.enumeration.UserLevel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "tbl_user";

    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String USERNAME = "user_name";
    public static final String PASSWORD = "password";
    public static final String IS_ACTIVE = "is_active";

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
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE, CascadeType.REFRESH})
    private Wallet wallet;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_mobile_numbers",
            joinColumns = @JoinColumn(name = "u_id")
    )
    @Column(name = "m_n", unique = true)
    private Set<String> mobileNumbers = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "user_codes",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "code", unique = true)
    private Set<Long> codes = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_user_level",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private Set<UserLevel> levels = new HashSet<>();

    //    @Embedded
    private BankInfo bankInfo;

    @ElementCollection
    @CollectionTable(name = "user_bank_infos")
    private Set<BankInfo> infos = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName,
                String username, String password, Boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
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

    public Set<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(Set<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Set<Long> getCodes() {
        return codes;
    }

    public void setCodes(Set<Long> codes) {
        this.codes = codes;
    }

    public Set<UserLevel> getLevels() {
        return levels;
    }

    public void setLevels(Set<UserLevel> levels) {
        this.levels = levels;
    }

    public BankInfo getBankInfo() {
        return bankInfo;
    }

    public void setBankInfo(BankInfo bankInfo) {
        this.bankInfo = bankInfo;
    }

    public Set<BankInfo> getInfos() {
        return infos;
    }

    public void setInfos(Set<BankInfo> infos) {
        this.infos = infos;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", wallet=" + wallet + '\'' +
                '}';
    }
}
