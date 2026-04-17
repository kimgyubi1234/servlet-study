package com.korit.servletstudy.login;

import com.korit.servletstudy.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@WebServlet("/api/auth/signin")
public class AuthenticationController extends HttpServlet {

    private User loginUser = User.builder()
            .id(1)
            .username("abcd")
            .password("1234")
            .email("abc@gmal.com")
            .build();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = JsonParserUtil.getJson(req);
        Map<String, Object> requestBody = JsonParserUtil.parse(json);
        System.out.println(requestBody);
        if (!loginUser.getUsername().equals(requestBody.get("username"))) {
            ResponseEntity.builder()
                    .status(403)
                    .body("사용자 정보가 일치하지 않습니다.")
                    .build()
                    .response(resp);
            return;
        }
        if (!loginUser.getUsername().equals(requestBody.get("password"))) {
            ResponseEntity.builder()
                    .status(403)
                    .body("사용자 정보가 일치하지 않습니다.")
                    .build()
                    .response(resp);
            return;

        }
        HttpSession session = req.getSession();
        session.setAttribute("authentication", loginUser);
        ResponseEntity.builder()
                .status(200)
                .body("로그인 완료.")
                .build()
                .response(resp);
        }
    }
