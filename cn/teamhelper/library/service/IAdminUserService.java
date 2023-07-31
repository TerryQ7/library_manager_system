package cn.teamhelper.library.service;

public interface IAdminUserService {

    boolean login(String username, String password);
    boolean recharge(String account, double money);
    void sort(int input);
}
