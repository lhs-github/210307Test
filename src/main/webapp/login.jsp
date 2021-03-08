<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/goods/login" method="post">
        name: <input type="text" name="username" /><br />
        email: <input type="text" name="email" /><br />
              <input type="submit" value="登录" />
    </form>
</body>
</html>
