package com.xinlee.demo.web;

import com.xinlee.demo.domain.User;
import com.xinlee.demo.service.UserService;
import com.xinlee.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by xin.lee on 2017/3/9.
 * 邮件激活Servlet
 */
public class ActiveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String code = request.getParameter("code");
            UserService userService = new UserServiceImpl();
            User user = userService.findByCode(code);
            if(null != user) {
                // 查询到用户
                user.setState(1);
                user.setCode(null);
                userService.update(user);
                request.setAttribute("msg", "激活成功，请去登录");
            }else {
                // 没有查询到用户
                request.setAttribute("msg", "激活码有误，请重新激活");
            }
            request.getRequestDispatcher("/WEB-INF/msg.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
