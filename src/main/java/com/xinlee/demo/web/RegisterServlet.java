package com.xinlee.demo.web;

import com.xinlee.demo.domain.User;
import com.xinlee.demo.service.UserService;
import com.xinlee.demo.service.impl.UserServiceImpl;
import com.xinlee.demo.utils.UUIDUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by xin.lee on 2017/3/9.
 * 用户注册Servlet
 */
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 接收处理数据
            request.setCharacterEncoding("utf-8");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String nickname = request.getParameter("nickname");
            String email = request.getParameter("email");
            // 封装数据
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setNickname(nickname);
            user.setEmail(email);
            user.setState(0);           // 0：未激活 1：已激活
            String uuid = UUIDUtil.getUUID(true);
            user.setCode(uuid + uuid);
            // 调用业务层处理数据
            UserService userService = new UserServiceImpl();
            userService.register(user);
            // 页面转发
            request.getRequestDispatcher("/WEB-INF/msg.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
