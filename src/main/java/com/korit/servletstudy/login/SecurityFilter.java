package com.korit.servletstudy.login;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;


public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) request;

        System.out.println(httpReq.getRequestURL());

        String uri = httpReq.getRequestURI();
        String progectNameIngnoreURI = uri.substring(uri.indexOf("/", 1));

        if(progectNameIngnoreURI.startsWith("/api/auth") ||
                progectNameIngnoreURI.startsWith("/api/html"))
        {
            chain.doFilter(request, response); // 통과
            return;
        }

        HttpSession session = httpReq.getSession();
        Object authArrtibute = session.getAttribute("authentication");
        if (authArrtibute == null) {                //authAttribute가 null이면 로그인이 안된 상태
            ResponseEntity.builder()
                    .status(403)
                    .body("로그인 후 이용가능합니다.")
                    .build()
                    .response(response);
            return; // 에러시 chain.doFilter로 못 넘어가게 막으려고
        }

        chain.doFilter(request, response); // 통과

    }

    private void errorResponse(HttpServletResponse resp, String message) throws IOException {
        resp.setStatus(403);
        resp.setContentType("application/json");
        Map<String, Object> responseMap = Map.of(
                "code", 403,
                "messege", message
        );
        resp.getWriter().println(JsonParserUtil.stringify(responseMap));
    }
}
