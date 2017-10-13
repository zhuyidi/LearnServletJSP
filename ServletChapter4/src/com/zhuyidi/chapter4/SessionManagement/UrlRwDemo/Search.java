package com.zhuyidi.chapter4.SessionManagement.UrlRwDemo;

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

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN'>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>搜索结果</title>");
        out.println("</head>");
        out.println("<body>");

        String start = req.getParameter("start");
        if(start == null){
            start = "1";
        }
        int count = Integer.parseInt(start);
        int begain = 10 * count - 9;
        int end = count * 10;

        out.println("第 " + begain + " 到 " + end + " 搜索结果<br>");
        out.println("<ul>");
        for(int i = 1; i <= 10; i++){
            out.println("<li>搜索结果" + i + "</li>");
        }
        out.println("</ul>");
        for(int i = 1; i < 10; i++){
            if(i == count){
                out.println(i);
                continue;
            }
            out.println("<a href='search?start=" + i + "'>" + i + "</a>");
        }
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
