package com.xinlee.demo.dao;

import com.xinlee.demo.domain.User;

import java.sql.SQLException;

/**
 * Created by xin.lee on 2017/3/9.
 * 用户持久层接口
 */
public interface UserDao {

    void register(User user) throws SQLException;

    User findByCode(String code) throws SQLException;

    void update(User user) throws SQLException;
}
