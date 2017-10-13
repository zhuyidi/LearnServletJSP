package com.zhuyidi.chapter4.SessionManagement.HttpSessionDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dela on 4/5/17.
 */

//千万千万注意url不能重复!!!!!
@WebServlet("/questionnairee")
public class Questionnaire extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Questionnaire</title>");
        out.println("</head>");
        out.println("<body>");
        String page = request.getParameter("page");
        out.println("<form action='questionnaire' method='post'>");
        if(page == null){
            out.println("问题一:<input type='text' name='p1q1'><br>");
            out.println("问题二:<input type='text' name='p1q2'><br>");
            out.println("<input type='submit' name='page' value='下一页'>");
        }else if("下一页".equals(page)){
            String p1q1 = request.getParameter("p1q1");
            String p1q2 = request.getParameter("p1q2");
            //这里改用HttpSession存储第一页答案
            HttpSession session = request.getSession();
            session.setAttribute("p1q1", p1q1);
            session.setAttribute("p1q2", p1q2);
            out.println("问题三:<input type='text' name='p2q1'><br>");
        }else if("完成".equals(page)){
            //此处改用HttpSession取得第一页的答案
            HttpSession session = request.getSession();
            session.getAttribute("p1q1");
            out.println(session.getAttribute("p1q1") + "<br>");
            out.println(session.getAttribute("p1q2") + "<br>");
            out.println(request.getParameter("p2q1") + "<br>");
        }
        out.println("</form>");
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
