package com.helloservlet.action;

import com.helloservlet.entity.Book;
import com.helloservlet.util.Db;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujn on 2019/8/19.
 */
@WebServlet(name = "BuyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Book book = Db.getAll().get(id);//得到用户想买的书
        HttpSession session = request.getSession();
        List<Book> list = (List)session.getAttribute("list");
        if(list==null){
            list = new ArrayList<Book>();
            session.setAttribute("list",list);
        }
        list.add(book);
        String url = response.encodeRedirectURL(request.getContextPath()
                +"/listBook");
        System.out.println(url);
        response.sendRedirect(url);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
