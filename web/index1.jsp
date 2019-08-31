<%--
  Created by IntelliJ IDEA.
  User: zhujn
  Date: 2019/8/20
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    当前系统在线人数是：
    <%=application.getAttribute("count")%>
    <a href="logout.jsp">退出系统</a>
</body>
</html>
