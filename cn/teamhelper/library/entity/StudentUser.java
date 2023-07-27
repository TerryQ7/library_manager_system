package cn.teamhelper.library.entity;

import java.io.Serializable;

public class StudentUser implements Serializable {
    private String name;
    private String account;
    private String password;
    private double balance;


    public StudentUser(String name, String account, String password) {
        this.name = name;
        this.account = account;
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


}
