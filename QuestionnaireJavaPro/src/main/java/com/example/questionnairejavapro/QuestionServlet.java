package com.example.questionnairejavapro;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet
public class QuestionServlet extends HttpServlet {

    static final int QUESTION_1_YES = 0;
    static final int QUESTION_1_NO = 1;
    static final int QUESTION_2_YES = 3;
    static final int QUESTION_2_NO = 4;
    static final String TEMPLATE = "<html>" +
            "<head><title>Prog Academy</title></head>" + "<body><h1>%s</h1></body></html>";
    final int[] results = new int[5];

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String q1 = req.getParameter("question1");
        final String q2 = req.getParameter("question2");

        final int idx1 = "yes".equals(q1) ? QUESTION_1_YES : QUESTION_1_NO;
        final int idx2 = "yes".equals(q2) ? QUESTION_2_YES : QUESTION_2_NO;

        results[idx1]++;
        results[idx2]++;

        String res = "<p>Question 1: yes = " + results[QUESTION_1_YES] + ", no = " + results[QUESTION_1_NO] + "</p>";
        res += "<p>Question 2: yes = " + results[QUESTION_2_YES] + ", no = " + results[QUESTION_2_NO] + "</p>";
        try (PrintWriter a = new PrintWriter("/Users/svetlana/Documents/JavaPro Progects/QuestionnaireJavaPro/Result.txt")) {
            a.println(String.format(TEMPLATE, res));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR FILE WRITE");
        }
        resp.getWriter().println("Response statistics written to file.");

    }

}