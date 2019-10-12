<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/9
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<form method="get" action="/user/login">
        用户名：<input type="text" name="name"/></br>
        密码： <input type="text" name="pwd" />
        <input type="submit" value="登录"/>
    </form>--%>
    <form method="post" action="/login">
        用户名：<input type="text" name="username"/></br>
        密码： <input type="text" name="password" />
        <input type="submit" value="登录"/>
    </form>
</body>
</html>
