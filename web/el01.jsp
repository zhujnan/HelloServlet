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
        <%
            User u = new User();
            u.setName("abc");
            u.setAge(22);
            IdCard card = new IdCard();
            card.setOrderNo("100");
            u.setCard(card);
            u.setInteres(new String[]{"钓鱼","打球"});
            request.setAttribute("user1",u);
        %>

        <!--java代码-->
        <%
            User u1 = (User)request.getAttribute("user1");
            System.out.println(u1.getName());
        %>
        <!--el表达式-->
        ${user1.name}<br/>
        ${user1.age}<br/>

        ${user1.card.orderNo}<br/>
        ${user1["name"]}<br/>
        ${user1.interes[1]}
        <hr/>

        <%request.setAttribute("prop","name");%>

</body>
</html>
