package cn.teamhelper.library.service.Implement;

import cn.teamhelper.library.entity.LibraryContext;
import cn.teamhelper.library.entity.StudentUser;
import cn.teamhelper.library.service.IStudentUserService;

import java.util.Map;

public class StudentUserServiceImpl implements IStudentUserService {

    @Override
    public boolean login(String username, String password) {
        Map<String, StudentUser> judge =  LibraryContext.queryByStudentUsername(username);
        try {
            assert judge != null;
            return judge.get(username).getPassword().equals(password);
        } catch (NullPointerException e) {
            return false;
        }
    }
}
