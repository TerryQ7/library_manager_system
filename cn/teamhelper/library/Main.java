package cn.teamhelper.library;

import cn.teamhelper.library.controller.AdminUserController;
import cn.teamhelper.library.entity.LibraryContext;
import cn.teamhelper.library.service.IAdminUserService;
import cn.teamhelper.library.service.impl.AdminUserServiceImpl;
import cn.teamhelper.library.util.FileUtils;
import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;





public class Main {

    public static void main(String[] args) throws IOException {
        init();
        LibraryContext context = new LibraryContext();
        LibraryContext.addAdminUsers("Tom", "Tom1", "TOM");
        LibraryContext.addAdminUsers("David", "David1", "DAVID");
        LibraryContext.addStudentUsers("Jerry", "Jerry1", "JERRY");
        LibraryContext.addStudentUsers("Andre", "Andre1", "ANDRE");
        LibraryContext.addStudentUsers("Jack", "Jack1", "JACK");

        FileUtils.serialize(context, "/Users/haiyang/Desktop/DataBase.txt");
        LibraryContext db = FileUtils.deserialize("/Users/haiyang/Desktop/DataBase.txt");
        System.out.println(JSON.toJSONString(db.getAdminUsers()));
        System.out.println(JSON.toJSONString(db.getStudentUsers()));
        System.out.println("Success");

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

    private static void init() throws IOException {
        //
        String dir = "/Users/haiyang/Desktop/DataBase.txt";
        File file = new File(dir);
        if (file.exists()) {
            LibraryContext db = FileUtils.deserialize("/Users/haiyang/Desktop/DataBase.txt");
        } else {
            LibraryContext.addAdminUsers("Admin", "admin", "12345");
        }
    }

}
