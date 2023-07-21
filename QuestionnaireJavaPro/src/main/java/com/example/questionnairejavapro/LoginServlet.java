package com.example.questionnairejavapro;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private String NAME;
    private String LAST_NAME;
    private int AGE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NAME = request.getParameter("name");
        LAST_NAME = request.getParameter("lastName");
        try {
            AGE = Integer.parseInt(request.getParameter("age"));
        } catch (NumberFormatException e) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_age", null);
        }


        if (!"".equals(NAME) && !"".equals(LAST_NAME) && AGE != 0) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_name", NAME);
            session.setAttribute("user_last_name", LAST_NAME);
            session.setAttribute("user_age", AGE);
        }

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);
        if ("exit".equals(a) && (session != null)) {
            session.removeAttribute("user_login");
        }
        response.sendRedirect("index.jsp");
    }
}
