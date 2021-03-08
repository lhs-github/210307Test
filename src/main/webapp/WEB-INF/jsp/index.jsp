<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    ${sessionScope.email}<br />
    <c:if test="${sessionScope.images} != ''">
    <img src="${sessionScope.images}" width="100" height="100" />
    </c:if><br />
    <a href="${pageContext.request.contextPath}/goods/temp">修改图片</a>
</body>
</html>
