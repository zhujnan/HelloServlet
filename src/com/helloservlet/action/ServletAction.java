package com.helloservlet.action;

import com.helloservlet.dao.EmpDao;
import com.helloservlet.dao.daoImp.EmpDaoImpl;
import com.helloservlet.entity.Emp;
import com.helloservlet.util.DaoFactory;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 登录请求
 * 控制层
 * Created by zhujn on 2019/8/15.
 */
public class ServletAction extends javax.servlet.http.HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
    }

    //  private EmpDao empdao = new EmpDaoImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Emp emp = new Emp();
        emp.setName(request.getParameter("name"));
        emp.setPwd(request.getParameter("pwd"));
        EmpDao empdao = (EmpDao)DaoFactory.getInstance("EmpDao");
        boolean bool = empdao.EmpLogin(emp);
       // ArrayList<Emp> list = empdao.findAll();
        if(bool){
            HttpSession session =
                    request.getSession();
            session.setAttribute("user",emp);

        //    request.setAttribute("emp","123");
           // request.setAttribute("emp2",emp);
           // request.setAttribute("empList",list);
            request.getRequestDispatcher("all.jsp")
                        .forward(request,response);
        }else{
            request.setAttribute("erromsg","用户名或密码错误");
            request.getRequestDispatcher("index.jsp")
                    .forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
