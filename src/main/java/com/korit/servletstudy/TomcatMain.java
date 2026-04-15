package com.korit.servletstudy;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Req {
    private String reqestUrl;
}

class Resp {

}
// 서블릿 영역
class TestServlet {
    private static TestServlet instance;
    private TestServlet() {}
    public static TestServlet getInstance() {
        if (instance == null) instance = new TestServlet();
        return instance;
    }
    public void init() {
        System.out.println("초기화");
    }
    public void service(Req req, Resp resp) {
        System.out.println(req.getReqestUrl());
    }
    public void destroy () {
        System.out.println("소멸");
    }
}
// 서비스 영역?
public class TomcatMain{
    public static void main(String[] args) {
        String requestUrl = "htt[://localhost:8080/backserver/first";
        TestServlet testServlet = TestServlet.getInstance();
        testServlet.init();
        testServlet.service(new Req(requestUrl), new Resp());
        testServlet.service(new Req(requestUrl), new Resp());
        testServlet.service(new Req(requestUrl), new Resp());
        testServlet.destroy();
    }
}
