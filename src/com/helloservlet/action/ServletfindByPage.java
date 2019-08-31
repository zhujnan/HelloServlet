package com.helloservlet.action;

import com.helloservlet.dao.EmpDao;
import com.helloservlet.dao.daoImp.EmpDaoImpl;
import com.helloservlet.entity.Emp;
import com.helloservlet.entity.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhujn on 2019/8/23.
 */
@WebServlet(name = "ServletfindByPage")
public class ServletfindByPage extends HttpServlet {
    EmpDao dao = new EmpDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        System.out.println("page的值为"+page);//当前页的值
        System.out.println("每页的行数"+rows);//每页行数
        PageBean pageBean = new PageBean(Integer.parseInt(page),
                Integer.parseInt(rows));
        Map<String,Object> map = new HashMap<String,Object>();
        System.out.println("每页开始位置"+pageBean.getStart());
        System.out.println("每页的行数"+pageBean.getPageSize());
        map.put("start",pageBean.getStart());//起始位置
        map.put("size",pageBean.getPageSize());//每页行数
        ArrayList<Emp> emps = dao.findbyPage(map);
        int total = dao.getTotal();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(emps);
        result.put("rows",jsonArray);
        result.put("total",total);
        PrintWriter out = response.getWriter();
        out.write(result.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
