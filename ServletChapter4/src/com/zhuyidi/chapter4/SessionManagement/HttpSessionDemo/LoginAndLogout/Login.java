package com.zhuyidi.chapter4.SessionManagement.HttpSessionDemo.LoginAndLogout;

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

@WebServlet("/selogin.do")
public class Login extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("selogin里面!!!");
        String user = req.getParameter("user");
        String passwd = req.getParameter("passwd");
        if("caterpillar".equals(user) && "123456".equals(passwd)){
            //当发现这个用户的名称和密码正确时, 就将这个用户设置为login属性
            req.getSession().setAttribute("login", user);
            req.getRequestDispatcher("/seuser.view").forward(req, resp);
        }
        else{
            resp.sendRedirect("login.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

