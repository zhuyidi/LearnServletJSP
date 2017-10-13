package com.zhuyidi.chapter3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dela on 3/8/17.
 */

@WebServlet("/pet")
public class PetServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置请求对象的字符编码
        req.setCharacterEncoding("UTF-8");

        //设置响应对象的字符编码
        resp.setContentType("text/html; charset=UTF-8");

        //取得响应输出对象
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>感谢填写</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("联系人:<a href='mailto:" +
                req.getParameter("email") + "'>" +
                req.getParameter("user") + "</a>");
        out.println("<br>喜爱的宠物类型");
        out.println("<ul>");
        for(String type:req.getParameterValues("type")){
            out.println("<li>" + type + "</li>");
        }
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
