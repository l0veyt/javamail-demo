package com.xinlee.demo.service;

import com.xinlee.demo.domain.User;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * Created by xin.lee on 2017/3/9.
 * 用户业务层接口
 */
public interface UserService {

    void register(User user) throws SQLException, MessagingException;

    User findByCode(String code) throws SQLException;

    void update(User user) throws SQLException;
}
