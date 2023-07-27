package cn.teamhelper.library.entity;

import cn.teamhelper.library.entity.AdminUser;
import cn.teamhelper.library.entity.Book;
import cn.teamhelper.library.entity.StudentUser;
import cn.teamhelper.library.service.IAdminUserService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
    数据库，存放账户信息
 */
public class LibraryContext<T> implements Serializable {
    private static Map<String, StudentUser> studentUsers = new HashMap<>();
    private static Map<String, AdminUser> adminUsers = new HashMap<>();
    private static Map<String, Book> books = new HashMap<>();



    public static void addAdminUsers(String name, String account, String password) {
        AdminUser adminUser1 = new AdminUser(name, account, password);
        adminUsers.put(account, adminUser1);
    }

    public static void addStudentUsers(String name, String account, String password) {
        StudentUser studentUser1 = new StudentUser(name, account, password);
        studentUsers.put(account, studentUser1);
    }

    public static void addBooks(String id, String title, String author, Boolean status) {
        Book book1 = new Book(id, title, author, status);
        books.put(title, book1);
    }

    public static T queryByUsername(String username) {
    }

    public boolean findBooks(Book book) {
        return books.containsKey(book.getTitle()) && (books.get(book.getTitle()).getAuthor().equals(book.getAuthor()));
    }


    // Add methods to manage users and books
}
