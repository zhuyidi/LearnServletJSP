package com.zhuyidi.chapter3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello1.view")
public class FirstServlet extends HttpServlet
{
    @Override   //重定义doGet
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8"); //设置响应内容类型器
        PrintWriter out = response.getWriter(); //取得响应输出对象
        String name = request.getParameter("name");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>hello Servlet</title>");
        out.println("<head>");
        out.println("<body>");
        out.println("<h1> hello!" + name + "!</h1>");
        out.println("</body>");
        out.println("</html>");

        out.close();
//      super.doGet(req, resp);
    }
}