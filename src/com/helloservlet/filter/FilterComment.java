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
     * ������ɾ��Filterʵ��֮ǰ�����ø÷���
     * ִֻ��һ��
     */
    public void destroy() {
    }

    /**
     * �����󵽴����������������doFilter����
     * �����Ὣ���ȴ����õ�request,response����
     * ��Ϊ�������ݽ���
     * ���������FilterChain.doFilter������
     * ��ʾ���ú����Ĺ����������û�й������ˣ�
     * ����ö�Ӧ��web�����
     * @param req
     * @param resp
     * @param chain :��������
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("������1");
        HttpServletResponse response =
                (HttpServletResponse) resp;
        HttpServletRequest request =
                (HttpServletRequest) req;
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String comment = request.getParameter("fl");
        if(comment.indexOf("sb")>=0){
            out.println("�Ƿ��ַ�");
        }else{
            chain.doFilter(req, resp);
        }
        System.out.println("������1����");

    }

    /**
     * servlet�����ڴ�����ʵ��֮�󣬻���������
     * init�����������ᴴ��FilterConfigʵ����ͨ��
     * ��ʵ�������Է���Filter�ĳ�ʼ������
     * init����ִֻ��һ��
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("��ʼ������");
    }

}
