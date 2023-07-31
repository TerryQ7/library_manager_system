package cn.teamhelper.library.controller;

import cn.teamhelper.library.service.IAdminUserService;

public class AdminUserController {

    private final IAdminUserService adminUserService;

    public AdminUserController(IAdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    public boolean login(String username, String password) {
        return adminUserService.login(username, password);
    }

    public boolean recharge(String account, double money) {
        return adminUserService.recharge(account, money);
    }

    public void sort(int input) {
        adminUserService.sort(input);
    }
}
