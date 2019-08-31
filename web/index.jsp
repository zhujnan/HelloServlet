<%--
  Created by IntelliJ IDEA.
  User: zhujn
  Date: 2019/8/15
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
        <form action="a" method="post">
          <legend>登录</legend>
            姓名： <input name="name"/><br/>
            密码:<input name="pwd"/><br/>
          <%
            String str = (String)request.getAttribute("erromsg");
          %>
            <input type="submit" value="登录"/>
          <span style="color:red"><%=(str==null?"":str)%></span>
        </form>
  </body>
</html>
