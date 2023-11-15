package com.kitri.jspbasic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");
        String result = "";

        switch (op) {
            case "+":
                result = plus(num1, num2);
                break;
            case "-":
                result = minus(num1, num2);
                break;
            case "*":
                result = multiply(num1, num2);
                break;
            case "/":
                result = divide(num1, num2);
                break;
        }

        PrintWriter out = resp.getWriter();
        out.println(num1 + " " + op + " " + num2 + " = " + result);

    }

    private String plus(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
    }
    private String minus(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2));
    }
    private String multiply(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2));
    }
    private String divide(String num1, String num2) {
        return String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2));
    }
}
