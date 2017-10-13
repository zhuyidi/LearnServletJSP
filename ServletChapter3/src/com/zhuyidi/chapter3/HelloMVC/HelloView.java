package com.zhuyidi.chapter3.HelloMVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dela on 3/7/17.
 */

@WebServlet("/hello.view")
public class HelloView extends HttpServlet {
    //先准备输出的HTML模版
    private String htmlTemplate =
            "<html>"
            + "<head>"
            + "<meta http-equiv='Content-Type'" +
                    "content='text/html'; charset=UTF-8>"
            + "<title>%s</title>"
            + "<body>"
            + "<h1>%s</h1>"
            + "</body>"
            + "</html>";

    //再重定义doGet方法

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //用getParametar()方法通过名称取得参数的值
        String user = req.getParameter("user");

        //再通过getAttribute取得已设置的请求属性的值
        String sentence = (String) req.getAttribute("message");

        //产生html结果并输出
        String html = String.format(htmlTemplate, user, sentence);
//        System.out.println(user + sentence);
        resp.getWriter().print(html);
    }
}
