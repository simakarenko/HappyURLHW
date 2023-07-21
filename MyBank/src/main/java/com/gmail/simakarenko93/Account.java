package com.gmail.simakarenko93;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private Long accountNumber;
    private Double allMoney;
    private String currency;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

    public Account() {
    }

    public Account(Long accountNumber, double allMoney, String currency) {
        this.accountNumber = accountNumber;
        this.allMoney = allMoney;
        this.currency = currency;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setBankAccount(this);
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
