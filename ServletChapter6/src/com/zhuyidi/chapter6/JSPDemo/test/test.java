package com.zhuyidi.chapter6.JSPDemo.test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by dela on 6/6/17.
 */
public class test extends HttpServlet{
    private String parameter1 = "name1";

    @Override
    public void init() throws ServletException {
        String parameter1 = getInitParameter("parameter1");
        System.out.println(parameter1);

    }
}
