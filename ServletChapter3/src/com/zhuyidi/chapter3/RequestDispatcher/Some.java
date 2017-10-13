package com.zhuyidi.chapter3.RequestDispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dela on 3/6/17.
 */

@WebServlet("/some.view") //如果此处有标注,则不必在web.xml文件再部署,否则将会引起奇怪的bug
public class Some extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("Some do one");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/other.view");
        dispatcher.include(req, resp);
        out.println("Some do two");
        out.close();
    }
}
