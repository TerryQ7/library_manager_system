package cn.teamhelper.library.service.impl;

import cn.teamhelper.library.entity.AdminUser;
import cn.teamhelper.library.service.IAdminUserService;
import cn.teamhelper.library.entity.LibraryContext;

import java.util.HashMap;
import java.util.Map;

public class AdminUserServiceImpl implements IAdminUserService {
    @Override
    public boolean login(String username, String password) {
        Map<String, String> judge =  LibraryContext.queryByUsername(username);
        try {
            assert judge != null;
            return judge.get(username).equals(password);
        } catch (NullPointerException e) {
            return false;
        }


        /*
         * 1. Use DB, query data object
         * 2. Check is null ?
         *  - if null, return false
         *  - if not null, equals password
         *    -  pass return true , else return false
         */
    }
}
