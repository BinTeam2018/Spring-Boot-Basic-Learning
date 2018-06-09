<%--
  Created by IntelliJ IDEA.
  User: binbin2018
  Date: 2018/6/8
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="/user/login" method="get">
    用户名：<input type="text" name="name"><br/>
    密码：<input type="text" name="pwd">
    <input type="submit" value="登录">
</form>
</body>
</html>
