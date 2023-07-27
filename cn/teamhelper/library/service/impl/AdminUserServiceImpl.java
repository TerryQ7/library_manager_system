package cn.teamhelper.library.service.impl;

import cn.teamhelper.library.entity.AdminUser;
import cn.teamhelper.library.service.IAdminUserService;
import cn.teamhelper.library.entity.LibraryContext;

import java.util.HashMap;
import java.util.Map;

public class AdminUserServiceImpl implements IAdminUserService {
    @Override
    public boolean login(String username, String password) {
        if (users.containsKey(username)) {
            return users.get(username).equals(password);
        }
        AdminUser user =  LibraryContext.queryByUsername(username);

        /**
         * 1. Use DB, query data object
         * 2. Check is null ?
         *  - if null, return false
         *  - if not null, equals password
         *    -  pass return true , else return false
         */
        return false;
    }
}
