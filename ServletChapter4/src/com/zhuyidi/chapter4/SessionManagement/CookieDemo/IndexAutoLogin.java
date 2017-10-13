package com.zhuyidi.chapter4.SessionManagement.CookieDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dela on 4/5/17.
 */

@WebServlet("/index.do")
public class IndexAutoLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("index里面!!!");
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                //如果这个cookie名称与数值符合, 表示允许自动登录
                if("user".equals(name) && "caterpillar".equals(value)){
                    request.setAttribute(name, value);
                    request.getRequestDispatcher("/user.view")
                            .forward(request, response);
                    return;
                }
            }
        }
        //如果没有相对应的cookie名称与数值,表示尚未允许自动登录, 重定向到登录窗体
        response.sendRedirect("login.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}
