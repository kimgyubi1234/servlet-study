package com.korit.servletstudy.login;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
