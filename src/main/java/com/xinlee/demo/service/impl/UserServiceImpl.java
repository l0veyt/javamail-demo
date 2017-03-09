package com.xinlee.demo.service.impl;

import com.xinlee.demo.dao.UserDao;
import com.xinlee.demo.dao.impl.UserDaoImpl;
import com.xinlee.demo.domain.User;
import com.xinlee.demo.service.UserService;
import com.xinlee.demo.utils.MailUtil;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * Created by xin.lee on 2017/3/9.
 * 用户业务层实例
 */
public class UserServiceImpl implements UserService {

    public void register(User user) throws SQLException, MessagingException {
        // 保存用户
        UserDao userDao = new UserDaoImpl();
        userDao.register(user);
        // 发送验证邮件
        MailUtil.sendMail(user.getEmail(), user.getCode());
    }

    public User findByCode(String code) throws SQLException {
        //
        UserDao userDao = new UserDaoImpl();
        return userDao.findByCode(code);
    }

    public void update(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }
}
