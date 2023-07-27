package cn.teamhelper.library.entity;

import java.io.Serializable;

public class AdminUser implements Serializable {
    private String name;
    private String account;
    private String password;


    public AdminUser(String name, String account, String password) {
        this.name = name;
        this.account = account;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

}
