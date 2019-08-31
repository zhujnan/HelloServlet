package com.helloservlet.listen;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by zhujn on 2019/8/20.
 */

public class CountListener implements HttpSessionListener {

    private int count = 0;
    /*
      session ����һ����������ִ�и÷���
       */
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        count++;
        HttpSession session = httpSessionEvent.getSession();
        ServletContext sctx = session.getServletContext();
        System.out.println("count"+count);
        sctx.setAttribute("count",count);
    }

    /**
     * session�������٣���ִ�и÷���
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
        HttpSession session = httpSessionEvent.getSession();
        ServletContext sttx = session.getServletContext();
        System.out.println("�˳�ʱ"+count);
        sttx.setAttribute("count",count);
    }
}
