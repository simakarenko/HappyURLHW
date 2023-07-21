package com.gmail.simakarenko93;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Account> bankAccounts = new HashSet<>();

    public User() {
    }

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void addAccount(Account account) {
        bankAccounts.add(account);
        account.setUser(this);
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Account> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(Set<Account> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
