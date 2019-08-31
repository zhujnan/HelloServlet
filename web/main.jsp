<%--
  Created by IntelliJ IDEA.
  User: zhujn
  Date: 2019/8/15
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.helloservlet.*,java.util.*" %>
<%@ page import="com.helloservlet.dao.EmpDao" %>
<%@ page import="com.helloservlet.util.DaoFactory" %>
<%@ page import="com.helloservlet.entity.Emp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Object obj = session.getAttribute("user");
    if(obj==null){
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
  <head>
    <title>$Title$</title>

      <link href="bootstrap3/css/bootstrap.min.css" rel="stylesheet">
      <script src="js/jquery-3.3.1.js"></script>
      <script src="js/bootstrap-paginator.js"></script>
      <script src="bootstrap3/js/bootstrap.min.js"></script>
      <script>
          $(function(){
              $.ajax({
                  url:"list",
                  dataType:"json",
                  data:{page:'1',rows:'5'},
                  success:function(data){
                    for(var i=0;i<data.rows.length;i++){
                        var trs = "";
                        trs+="<tr><td>" +data.rows[i].name
                                +"</td><td>"+data.rows[i].pwd
                                +"</td><td>"+data.rows[i].age
                                 +"</td><td>"+data.rows[i].sal
                                +"</td></tr>"
                        $("#tb").append(trs);
                    }
                  } });

              $('#pageLimit').bootstrapPaginator({
                  currentPage: 1,//当前的请求页面。
                  totalPages: 20,//一共多少页。
                  size:"normal",//应该是页眉的大小。
                  bootstrapMajorVersion: 3,//bootstrap的版本要求。
                  alignment:"right",
                  numberOfPages:5,//一页列出多少数据。
                  itemTexts: function (type, page, current) {//如下的代码是将页眉显示的中文显示我们自定义的中文。
                      switch (type) {
                          case "first": return "首页";
                          case "prev": return "上一页";
                          case "next": return "下一页";
                          case "last": return "末页";
                          case "page": return page;
                      }
                  }
              });
          });
      </script>
  </head>
  <body>
    <span style='color:red;'> <%=request.getAttribute("emp") %></span>
  <span style='color:red;'>欢迎来到英格之家!${emp2.name}</span>  <br/>
  <table>
      <thead>
      <tr>
          <td>姓名</td>
          <td>密码</td>
          <td>工资</td>
          <td>年龄</td>
      </tr>
      <thead/>
      <tbody id="tb">

      </tbody>
      <!--
            varStatus：循环标签的一个属性
            varStatus="status"定义了一个status名的对象作为
            varStatus的绑定值。
            绑定值封装了当前遍历的状态，可以从该对象上查看遍历到了
            第几个元素：${status.count}
      -->
</table>
  <div id="example" style="text-align: center">
      <ul id="pageLimit"></ul>
  </div>
  </body>
</html>
