package com.zhuyidi.chapter3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dela on 3/1/17.
 */

@WebServlet("/body.view")
class BodyServlet extends HttpServlet{

    private String readBody(HttpServletRequest req)
       throws IOException{
        BufferedReader reader = req.getReader(); //取得BufferedReader对象
        String reqBody = "";
        String input = null;

        while((input = reader.readLine()) != null){
            reqBody += input + "<br>";
        }
        return reqBody;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //System.out.println("1111");
        String body = readBody(req);
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet BodyView</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(body);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
