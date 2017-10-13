package com.zhuyidi.chapter5.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by dela on 6/7/17.
 */

@WebFilter(filterName = "performance", urlPatterns = {"/*"})
public class PerformanceFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig config) throws ServletException{
        this.config = config;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        long begain = System.currentTimeMillis();
        chain.doFilter(request, response);
        config.getServletContext().log("Request process in " + (System.currentTimeMillis() - begain) + " milliseconds");
        //System.out.print("Request process in " + (System.currentTimeMillis() - begain) + " milliseconds");
    }

    @Override
    public void destroy(){}
}
