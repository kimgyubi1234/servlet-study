package com.korit.servletstudy.login;

import com.korit.servletstudy.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@WebServlet("/api/auth/signin")
public class AuthenticationController extends HelloServlet {

    private User loginUser = User.builder()
            .id(1)
            .username("abcd")
            .password("1234")
            .name("김준일")
            .build();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonParserUtil.getJson(req);
        Map<String, Object> requestBody = JsonParserUtil.parse(json);
        System.out.println(requestBody);
        if (!loginUser.getUsername().equals(requestBody.get("username"))) {
            errorResponse(resp, "사용자 정보가 일치하지 않습니다.");
        }
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
