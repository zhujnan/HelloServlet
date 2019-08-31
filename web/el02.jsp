<%--
  Created by IntelliJ IDEA.
  User: zhujn
  Date: 2019/8/17
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.helloservlet.entity.*"%>
<head>
    <title>Title</title>
</head>
<body>
    <!--
        http://localhost:8080/el02.jsp?un=zz&interest=f&interest=l
    -->
    userName:${param.un}
    interest:${paramValues.interest[0]}
    interest:${paramValues.interest[1]}
<!--算术运算-->
    ${1+2}
    ${"1"+"2"}
<!--关系运算-->
    ${"abc"=="abc"}
    ${"abc" eq "abc"}
<!--empty运算-->
    <% request.setAttribute("str1",""); %>
    str1的结果为: ${empty str1}
</body>
</html>
