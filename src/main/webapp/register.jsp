<%--
  Created by IntelliJ IDEA.
  User: xin.lee
  Date: 2017/3/9
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册页面</title>
    <%@ include file="/header.jsp"%>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <h1>用户注册的页面</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" action="${pageContext.request.contextPath}/register" method="post">
                    <div class="form-group">
                        <label for="inputUsername" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputUsername" name="username" placeholder="请输入用户名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="inputPassword" name="password" placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputNickname" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="inputNickname" name="nickname" placeholder="请输入昵称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-sm-2 control-label">邮箱</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" id="inputEmail" name="email" placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">注册</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
