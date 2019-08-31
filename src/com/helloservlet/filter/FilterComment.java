package com.helloservlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhujn on 2019/8/20.
 */
@WebFilter(filterName = "FilterComment")
public class FilterComment implements Filter {
    /**
     * 在容器删除Filter实例之前，掉用该方法
     * 只执行一次
     */
    public void destroy() {
    }

    /**
     * 当请求到达容器，容器会调用doFilter方法
     * 容器会将事先创建好的request,response对象
     * 作为参数传递进来
     * 如果调用了FilterChain.doFilter方法，
     * 表示调用后续的过滤器，如果没有过滤器了，
     * 则调用对应的web组件。
     * @param req
     * @param resp
     * @param chain :过滤器链
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器1");
        HttpServletResponse response =
                (HttpServletResponse) resp;
        HttpServletRequest request =
                (HttpServletRequest) req;
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String comment = request.getParameter("fl");
        if(comment.indexOf("sb")>=0){
            out.println("非法字符");
        }else{
            chain.doFilter(req, resp);
        }
        System.out.println("过滤器1结束");

    }

    /**
     * servlet容器在创建好实例之后，会立即调用
     * init方法，容器会创建FilterConfig实例，通过
     * 该实例，可以访问Filter的初始化参数
     * init方法只执行一次
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化方法");
    }

}
