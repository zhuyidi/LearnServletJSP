package com.zhuyidi.chapter5.ServletConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dela on 4/20/17.
 */

//name是servlet的名称, initParams中设置初始参数
@WebServlet(
        name = "login",
        urlPatterns = {"/login.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS", value = "success.html"),
                @WebInitParam(name = "ERROR", value = "/html/error.html")
        }
)
public class Login extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException {
        SUCCESS_VIEW = getInitParameter("SUCCESS");
        ERROR_VIEW = getInitParameter("ERROR");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        String name = req.getParameter("name");
        String passwd = req.getParameter("passwd");

        System.out.println(name);
        System.out.println(passwd);

        if("caterpillar".equals(name) && "123456".equals(passwd)){
            System.out.println("success");
            req.getRequestDispatcher(SUCCESS_VIEW).forward(req, resp);
        }else{
            System.out.println("error");
            req.getRequestDispatcher(ERROR_VIEW).forward(req, resp);
        }
    }
}
