package com.ciklum.ciklumwebhw3.util;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("MyFilter doFilter() is invoked.");
        Enumeration<String> params = req.getParameterNames();
        while (params.hasMoreElements()) {
            String param=params.nextElement();
            System.out.println("Parameter:"+param+"\tValue:"+req.getParameter(param));
        }
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}