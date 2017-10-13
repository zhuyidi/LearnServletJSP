package com.zhuyidi.chapter4.SessionManagement.CookieDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dela on 4/5/17.
 */
@WebServlet("/user.view")
public class User extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("user里面!!!!");
        response.setContentType("text/html; charset=UTF-8");
        //若请求中没有user属性, 则表示用户未登录
        if(request.getAttribute("user") == null){
            response.sendRedirect("login.html");
        }
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet User</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + request.getAttribute("user") + "已登录</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
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
