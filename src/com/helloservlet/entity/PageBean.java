package com.helloservlet.entity;

/**
 * Created by zhujn on 2019/8/23.
 */
public class PageBean {
    private int page;//当前页
    private int pageSize;//每页显示行数
    private int start;//开始记录
    public PageBean(int page,int pageSize){
        this.page = page;
        this.pageSize = pageSize;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getStart(){
        return (page-1)*pageSize;
    }
}
