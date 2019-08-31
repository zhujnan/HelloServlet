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
      session 对象一旦创建，会执行该方法
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
     * session对象被销毁，会执行该方法
     * @param httpSessionEvent
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        count--;
        HttpSession session = httpSessionEvent.getSession();
        ServletContext sttx = session.getServletContext();
        System.out.println("退出时"+count);
        sttx.setAttribute("count",count);
    }
}
