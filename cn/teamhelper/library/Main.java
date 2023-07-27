package cn.teamhelper.library;

import cn.teamhelper.library.controller.AdminUserController;
import cn.teamhelper.library.service.IAdminUserService;
import cn.teamhelper.library.service.impl.AdminUserServiceImpl;

import java.io.File;
import java.util.Scanner;





public class Main {

    public static void main(String[] args) {
        // chushi
        init();

        //
    }

    public static void handleLogin() {
        IAdminUserService adminUserService = new AdminUserServiceImpl();
        AdminUserController adminUserController = new AdminUserController(adminUserService);

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        boolean login = adminUserService.login(username, password);
        if (login) {
            System.out.println("登录成功！");
        } else {
            System.out.println("用户名或密码错误，登录失败！");
        }

        scanner.close();
    }

    private static void init() {
        //
        String dir = "~/Desktop/";
        String dbName = "lib.tx";
        File file = new File(dir + dbName);
        if (file.exists()) {

        } else {

        }
    }


}
