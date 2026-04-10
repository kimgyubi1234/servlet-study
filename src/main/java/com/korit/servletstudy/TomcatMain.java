package com.korit.servletstudy;

class Req {

}

class Resp {

}

class TestServlet {
    private static TestServlet instance;
    private TestServlet() {}
    public static TestServlet getInstance() {
        if (instance == null) instance = new TestServlet();
        return instance;
    }
    public void init() {}
    public void service(Req req, Resp resp) {}
    public void destroy () {}
}

public class TomcatMain extends HelloServlet{
}
