package com.zhuyidi.chapter3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dela on 3/1/17.
 */

@WebServlet("/encoding")
public class EncodingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("nameGet");
        name = new String(name.getBytes("ISO-8859-1"), "BIG5");
        System.out.println("GET: " + name);
    }
}
