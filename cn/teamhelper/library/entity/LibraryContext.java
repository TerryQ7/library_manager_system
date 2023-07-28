package cn.teamhelper.library.entity;

import cn.teamhelper.library.entity.AdminUser;
import cn.teamhelper.library.entity.Book;
import cn.teamhelper.library.entity.StudentUser;
import cn.teamhelper.library.service.IAdminUserService;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
    数据库，存放账户信息
 */
public class LibraryContext implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Map<String, StudentUser> studentUsers = new HashMap<>();
    private static final Map<String, AdminUser> adminUsers = new HashMap<>();
    private static final Map<String, Book> books = new HashMap<>();


    public static Map<String, AdminUser> getAdminUsers() {
        return adminUsers;
    }

    public static Map<String, StudentUser> getStudentUsers() {
        return studentUsers;
    }

    public static Map<String, Book> getBooks() {
        return books;
    }

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

    public static Map<String, String> queryByUsername(String account) {
        Map<String, String> toReturn = new HashMap<>();
        if (adminUsers.containsKey(account)) {
            toReturn.put(account, adminUsers.get(account).getPassword());
            return toReturn;
        } else if (studentUsers.containsKey(account)) {
            toReturn.put(account, studentUsers.get(account).getPassword());
            return toReturn;
        } else {
            return null;
        }
    }

    public boolean findBooks(Book book) {
        return books.containsKey(book.getTitle()) && (books.get(book.getTitle()).getAuthor().equals(book.getAuthor()));
    }


    // Add methods to manage users and books
}
