package com.korit.servletstudy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstSurvelt extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = "abcd";

        resp.getWriter().println(username); //resp 리스폰스 > 응답// 응답 객체로부터 겟라이터(작성할 수 있는것)를 가져와라
    }
}
