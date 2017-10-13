package com.zhuyidi.chapter5.ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

/**
 * Created by dela on 4/24/17.
 */

//servlet监听器直接使用WebListener标注, 并必须实现ServletContextListener接口,
//这样容器在启动时就会加载并运行对应的方法.
@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //contextInitialized实现应用程序资源的准备工作

        //先取得ServletContext对象
        ServletContext context = sce.getServletContext();
        //取得初始参数
        String avatars = context.getInitParameter("AVATAR");
        //设置ServletContext属性
        context.setAttribute("avatars", avatars);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){}
}
