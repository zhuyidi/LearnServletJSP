package com.zhuyidi.chapter5.HttpSessionListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dela on 4/25/17.
 */

//@WebServlet("/login.do")
public class Login extends HttpServlet {
    private Map<String, String> users;

    public Login(){
        users = new HashMap<String, String>();
        users.put("caterpillar", "123456");
        users.put("dela", "111111");
        users.put("zhuyidi", "111111");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");

        String page = "form.html";
        if(users.containsKey(name) && users.get(name).equals(passwd)){
            req.getSession().setAttribute("user", name);
            page = "welcome.view";
        }
        resp.sendRedirect(page);
    }
}
