package com.cuiwz.service;

import com.cuiwz.po.User;

/**
 * Created by cuiwz on 2020/02/22.
 */
public interface UserService {

    User checkUser(String username, String password);
}
