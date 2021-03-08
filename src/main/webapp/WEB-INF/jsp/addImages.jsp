<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/goods/addImages" method="post" enctype="multipart/form-data">
         comment: <input type="text" name="address" /> <br />
         file:    <input type="file" name="fileUpload" /><br />
                  <input TYPE="submit" vlaue="提交" />
    </form>
</body>
</html>
