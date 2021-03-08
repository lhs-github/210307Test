<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/3
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/goods/add">
    name: <input type="text" name="username" /><br />
    pass: <input type="password" name="password" /><br />
    <input type="submit" value="添加" />
</form>
</body>
</html>
