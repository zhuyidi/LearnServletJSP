package com.zhuyidi.chapter3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dela on 2/28/17.
 */

@WebServlet("/servlet/*")
public class PathServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Pattern</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(req.getRequestURI() + "<br>");  //由于当前环境路径为默认设置(即/),所以在web页面上显示得到的环境路径为空(null)
        out.println(req.getContextPath() + "<br>");
        out.println(req.getServletPath() + "<br>");
        out.println(req.getPathInfo());
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
