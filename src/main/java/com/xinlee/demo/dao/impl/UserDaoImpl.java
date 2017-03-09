package com.xinlee.demo.dao.impl;

import com.xinlee.demo.dao.UserDao;
import com.xinlee.demo.domain.User;
import com.xinlee.demo.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * Created by xin.lee on 2017/3/9.
 * 用户持久层实例
 */
public class UserDaoImpl implements UserDao {

    /**
     * 用户注册
     * @param user 用户实例
     */
    public void register(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());
        String sql = "insert into user values (?,?,?,?,?,?,?)";
        Object[] params = {user.getUid(), user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getState(), user.getCode()};
        queryRunner.update(sql, params);
    }

    /**
     * 用过代码查询用户
     * @param code 激活代码
     * @return 用户实例
     */
    public User findByCode(String code) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());
        String sql = "select * from user where code = ?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class), code);
        return user;
    }

    public void update(User user) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Util.getComboPooledDataSource());
        String sql = "update user set username = ?, password = ?, nickname = ?, email = ?, state = ?, code = ? where uid = ?";
        Object[] params = {user.getUsername(), user.getPassword(), user.getNickname(), user.getEmail(), user.getState(), user.getCode(), user.getUid()};
        queryRunner.update(sql, params);
    }
}
