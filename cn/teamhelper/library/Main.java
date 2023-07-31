package cn.teamhelper.library;

import cn.teamhelper.library.controller.AdminUserController;
import cn.teamhelper.library.controller.StudentUserController;
import cn.teamhelper.library.entity.LibraryContext;
import cn.teamhelper.library.service.IAdminUserService;
import cn.teamhelper.library.service.IStudentUserService;
import cn.teamhelper.library.service.Implement.AdminUserServiceImpl;
import cn.teamhelper.library.service.Implement.StudentUserServiceImpl;
import cn.teamhelper.library.util.FileUtils;
import com.alibaba.fastjson.JSON;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;





public class Main {
    private static LibraryContext dataBase;
    private static final String directory = "/Users/haiyang/Desktop/DataBase.txt";;

    public static void main(String[] args) throws IOException {
        dataBase = init();

        firstStep();
    }


    private static LibraryContext init() throws IOException {

        File file = new File(directory);
        if (!file.exists()) {
            LibraryContext.addAdminUsers("Admin", "admin", "12345");
            FileUtils.serialize(dataBase, directory);
        } else {
            dataBase = FileUtils.deserialize(directory);
        }
        return dataBase;
    }



    public static void firstStep() throws IOException{
        Scanner menu = new Scanner(System.in);

        System.out.println("请选择您要进行的操作: 1.登陆   2.注册   3.退出");
        int option = menu.nextInt();

        if (option == 1) {
            Scanner loginMenu = new Scanner(System.in);
            System.out.println("请选择您的账户类型: 1.管理员账户   2.学生账户   3.返回上一级");

            int loginOption = loginMenu.nextInt();

            if (loginOption == 1) {
                handleAdminLogin();
            } else if (loginOption == 2) {
                handleStudentLogin();
            } else if (loginOption == 3) {
                firstStep();
            }
            loginMenu.close();

        } else if (option == 2) {
            handleSignUp();

        } else if (option == 3) {
            FileUtils.serialize(dataBase, directory);
            menu.close();
            System.exit(1);

        }
        menu.close();
    }

    public static void handleAdminLogin() throws IOException {
        IAdminUserService adminUserService = new AdminUserServiceImpl();
        AdminUserController adminUserController = new AdminUserController(adminUserService);

        Scanner scanner = new Scanner(System.in);


        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        boolean login = adminUserController.login(username, password);
        if (login) {
            System.out.println("登录成功！");
            AdminLogin();
        } else {
            System.out.println("用户名或密码错误，登录失败！");
            handleAdminLogin();
        }

        scanner.close();
    }

    private static void handleStudentLogin() {
        IStudentUserService studentUserService = new StudentUserServiceImpl();
        StudentUserController studentUserController = new StudentUserController(studentUserService);

        Scanner scanner = new Scanner(System.in);


        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        boolean login = studentUserController.login(username, password);
        if (login) {
            System.out.println("登录成功！");
        } else {
            System.out.println("用户名或密码错误，登录失败！");
            handleStudentLogin();
        }

        scanner.close();
    }

    public static void handleSignUp() throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入昵称：");
        String name = scanner.nextLine();

        System.out.println("请输入用户名：");
        String account = scanner.nextLine();

        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        LibraryContext.addStudentUsers(name, account, password);
        System.out.println("注册成功");
        FileUtils.serialize(dataBase, directory);
        scanner.close();

        firstStep();
    }

    public static void AdminLogin() throws IOException {
        /*
            1. 方法：充值，排序
         */

        IAdminUserService adminUserService = new AdminUserServiceImpl();
        AdminUserController adminUserController = new AdminUserController(adminUserService);

        Scanner menu = new Scanner(System.in);

        System.out.println("请选择您要进行的操作: 1.充值   2.管理图书   3.退出");
        int option = menu.nextInt();

        if (option == 1) {
            Scanner scanner  = new Scanner(System.in);

            System.out.println("请输入您要充值的账户：");
            String account = scanner.nextLine();

            System.out.println("请输入您要充值的金额：");
            double money = Double.parseDouble(scanner.nextLine());

            adminUserController.recharge(account, money);

            scanner.close();
            AdminLogin();
        } else if (option == 2) {
            System.out.println("请选择您要进行的操作: 1.增加图书   2.删减图书   3.图书排序    4.返回上一级");
            Scanner scanner  = new Scanner(System.in);
            int o = scanner.nextInt();
            if (o == 1) {
                System.out.println("请输入书的id：");
                Scanner s = new Scanner(System.in);
                int id = s.nextInt();

                System.out.println("请输入书名：");
                String title = s.nextLine();

                System.out.println("请输入书的作者：");
                String author = s.nextLine();

                LibraryContext.addBooks(id, title, author, true);
                s.close();
                AdminLogin();
            } else if (o == 2) {
                System.out.println("请输入书的id：");
                Scanner s = new Scanner(System.in);
                int id = s.nextInt();
            }


        } else if (option == 3) {
            FileUtils.serialize(dataBase, directory);
            menu.close();
            System.exit(1);

        }

    }
}

