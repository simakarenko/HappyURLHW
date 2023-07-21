package academy.prog;

import jakarta.servlet.http.*;

import java.io.IOException;

// Req -> (S -> S) -> jsp

public class LoginServlet extends HttpServlet {
    static final String LOGIN = "admin";
    static final String PASS = "admin";
    private int AGE;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        AGE = Integer.parseInt(request.getParameter("age"));

        if (AGE < 18 && LOGIN.equals(login) && PASS.equals(password)) {
            System.out.println(AGE);
            HttpSession session = request.getSession(true);
            session.setAttribute("user_age", AGE);
        }

        if (LOGIN.equals(login) && PASS.equals(password) && AGE >= 18) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user_login", login);
        }

        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = request.getParameter("a");
        HttpSession session = request.getSession(false);
        if (AGE < 18 && "exit".equals(a) && (session != null)) {
            session.removeAttribute("user_age");

        } else if ("exit".equals(a) && (session != null)) {
            session.removeAttribute("user_login");
        }
        response.sendRedirect("index.jsp");
    }
}
