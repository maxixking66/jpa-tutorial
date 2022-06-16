package com.makatabsharif74.jpatutorial.domain.embedables;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BankInfo implements Serializable {

    @Column(name = "c_n")
    private String cardNumber;

    @Column(name = "a_n")
    private String accountNumber;

    @Column(name = "s_n")
    private String shebaNumber;

    @Column(name = "cvv2_n")
    private String cvv2Number;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getShebaNumber() {
        return shebaNumber;
    }

    public void setShebaNumber(String shebaNumber) {
        this.shebaNumber = shebaNumber;
    }

    public String getCvv2Number() {
        return cvv2Number;
    }

    public void setCvv2Number(String cvv2Number) {
        this.cvv2Number = cvv2Number;
    }
}
