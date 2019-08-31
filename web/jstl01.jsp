<%--
  Created by IntelliJ IDEA.
  User: zhujn
  Date: 2019/8/17
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.helloservlet.entity.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>Title</title>
</head>
<body>
        <%
          Person p = new Person();
          p.setName("zs");
          p.setGendar("f");
          request.setAttribute("user1",p);
        %>
        姓名：${user1.name}<br/>
        性别：<c:if test="${user1.gendar == 'm'}" var="rs" scope="request">
                男
              </c:if>
              <c:if test="${!rs}">
                  女
              </c:if>
<hr/>
        用户性别：
        <c:choose>
                <c:when test="${user1.gendar=='m'}">男</c:when>
                <c:otherwise>女</c:otherwise>
        </c:choose>
<hr/>
        <c:catch var="msg">
            <%
                Integer.parseInt("123a");
            %>
        </c:catch>
        ${msg}
        <hr/>
        jstl01..<br/>
        <c:import url="el01.jsp"/><br/>
        <hr/>
        <c:out value="${1+1}"/><br/>
        ${1+1}
        <c:out value="${str}" default="hello"/><br/>
</body>
</html>
