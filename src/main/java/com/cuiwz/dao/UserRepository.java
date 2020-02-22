package com.cuiwz.dao;

import com.cuiwz.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuiwz on 2020/02/22.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
