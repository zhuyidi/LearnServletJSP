package com.zhuyidi.chapter5.HttpSessionListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dela on 4/25/17.
 */

@WebServlet("/welcome.view")
public class Welcome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>欢迎</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>当前在线人数" + OnlineUserCounter.getCounter() + "人</h1>");
        if(session != null){
            String user = (String) session.getAttribute("user");
            out.println("<h1>欢迎" + user + "</h1>");
            out.println("<a href = 'logout.do'>注销</a>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
