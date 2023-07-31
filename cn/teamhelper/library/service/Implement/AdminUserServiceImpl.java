package cn.teamhelper.library.service.Implement;

import cn.teamhelper.library.entity.AdminUser;
import cn.teamhelper.library.entity.Book;
import cn.teamhelper.library.entity.StudentUser;
import cn.teamhelper.library.service.IAdminUserService;
import cn.teamhelper.library.entity.LibraryContext;

import java.util.List;
import java.util.Map;



public class AdminUserServiceImpl implements IAdminUserService {
    @Override
    public boolean login(String username, String password) {
        Map<String, AdminUser> judge =  LibraryContext.queryByAdminUsername(username);
        try {
            assert judge != null;
            return judge.get(username).getPassword().equals(password);
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean recharge(String account, double money) {
        StudentUser student = LibraryContext.queryByStudentUsername(account).get(account);
        if (student != null) {
            student.setBalance(money);
            System.out.println("充值成功");
            return true;
        } else {
            System.out.println("无法查询到此账户，充值失败，请检查后重试");
            return false;
        }
     }

    @Override
    public void sort(int input) {
        List<Book> books = LibraryContext.getBooks();
        if (input == 1) { //sort by id
            books.sort(Book.IdComparator);
        } else if (input == 2) { //sort by Title
            books.sort(Book.TitleComparator);
        } else if (input == 3) { //sort by Author
            books.sort(Book.AuthorComparator);
        } else if (input == 4) {
            books.sort(Book.StatusComparator);
        }
    }
}
