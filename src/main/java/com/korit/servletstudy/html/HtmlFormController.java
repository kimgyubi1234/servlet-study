package com.korit.servletstudy.html;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Arrays;

@MultipartConfig
@WebServlet("/api/html/form")
public class HtmlFormController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] job1 = req.getParameterValues("job1");
        String job2 = req.getParameter("job2");
        Part part = req.getPart("profileFile");
        System.out.println(part.getSubmittedFileName());
        InputStream inputStream = part.getInputStream();
        String filePath = req.getServletContext().getRealPath("/WEB-INF/") + part.getSubmittedFileName();
        OutputStream outputStream = new FileOutputStream(filePath);
        byte[] buf = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(buf, 0, 1024)) != -1) {
            outputStream.write(buf, 0, length);
            outputStream.flush();
        }

        System.out.println(username);
        System.out.println(password);
        System.out.println(Arrays.toString(job1));
        System.out.println();
    }
}
