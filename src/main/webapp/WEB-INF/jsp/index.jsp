<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/8
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   单个文件上传:<br/>
   <form action="/user/upload" method="post" enctype="multipart/form-data">
       <input type="file" name="file"/>
       <input type="submit" value="提交上传"/>
   </form>
   多个文件上传:<br/>
   <form action="/user/uploads" method="post" enctype="multipart/form-data">
       文件1:<input type="file" name="file"/><br/>
       文件2:<input type="file" name="file"/><br/>
       文件3:<input type="file" name="file"/><br/>
       <input type="submit" value="上传多个文件"/>
   </form>
</body>
</html>
