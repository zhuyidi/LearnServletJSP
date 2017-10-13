package com.zhuyidi.chapter3.HelloMVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dela on 3/7/17.
 */

@WebServlet("/hello.do")
public class HelloController extends HttpServlet {

    //在控制器中定义HelloModel类
    private HelloModel model= new HelloModel();

    //重定义doGet方法

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        System.out.println("1");
        //通过指定请求的参数的名称来取得对应的值
        String name = req.getParameter("user");

//        System.out.println("2");
        //委托HelloModel对象模型进行处理
        String message = model.doHello(name);

//        System.out.println("control" + message);
        System.out.println("3");
        //将HelloModel中的结果信息通过setAttribute()设置至请求对象成为属性
        req.setAttribute("message", message);

//        System.out.println("3");
        //将此请求转发给hello.view(HelloView视图)进行响应,使其呈现画面
        req.getRequestDispatcher("hello.view").forward(req, resp);

//        System.out.println("4");
    }
}
