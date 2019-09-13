package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyNameServlet extends HttpServlet {
    private String name;
    private String email;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        name = config.getInitParameter("name");
        email = getServletContext().getInitParameter("email");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(name + "/" + email);
    }
}
