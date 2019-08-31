package com.helloservlet.action;

import com.helloservlet.entity.Book;
import com.helloservlet.util.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhujn on 2019/8/19.
 */
@WebServlet(name = "ServletBookIndex")
public class ServletBookIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.getSession();
        PrintWriter out= response.getWriter();
        out.write("网站有如下书:<br/>");
        Set<Map.Entry<String,Book>> set = Db.getAll().entrySet();
        for(Map.Entry<String,Book> me: set){
            Book book = me.getValue();
            String url = request.getContextPath()+"/buyServlet?id="+book.getId();
            url = response.encodeURL(url);//将超链接的url地址重写
            out.println(book.getName()+" <a href='"+url+"'>购买</a><br/>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
