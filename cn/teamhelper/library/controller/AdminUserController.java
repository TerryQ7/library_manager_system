package cn.teamhelper.library.controller;

import cn.teamhelper.library.service.IAdminUserService;

public class AdminUserController {

    private IAdminUserService adminUserService;

    public AdminUserController(IAdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    boolean login(String username, String password) {
        return adminUserService.login(username, password);
    }
}
