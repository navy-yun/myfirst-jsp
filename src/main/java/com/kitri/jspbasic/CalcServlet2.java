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
public class CalcServlet2 extends HttpServlet {
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

        out.println("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>JSP 기초 - 심플 계산기</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"container\">\n" +
                "    <h3>Very Simple Calculator</h3>\n" +
                "    <form action=\"calc\" method=\"get\">\n" +
                "        <div>\n" +
                "            <input type=\"number\" name=\"num1\">\n" +
                "            <select name=\"op\">\n" +
                "                <option value=\"+\">+</option>\n" +
                "                <option value=\"-\">-</option>\n" +
                "                <option value=\"*\">*</option>\n" +
                "                <option value=\"/\">/</option>\n" +
                "            </select>\n" +
                "            <input type=\"number\" name=\"num2\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <input type=\"submit\" value=\"=\">\n" + result +
                "        </div>\n" +
                "    </form>\n" +
                "</div>\n" +
                "</body>\n" +
                "<style>\n" +
                "html {\n" +
                "    height: 100%;\n" +
                "}\n" +
                "body {\n" +
                "    box-sizing: border-box;\n" +
                "    display: flex;\n" +
                "    align-items: center;\n" +
                "    justify-content: center;\n" +
                "    height: 60%;\n" +
                "}\n" +
                "h3 {\n" +
                "    margin-top: 0px;\n" +
                "    padding-top: 0px;\n" +
                "}\n" +
                "#container {\n" +
                "    border-style: solid;\n" +
                "    display: flex;\n" +
                "    flex-direction: column;\n" +
                "    align-items: center;\n" +
                "    justify-content: center;\n" +
                "    width: 300px;\n" +
                "    height: 150px;\n" +
                "}\n" +
                "input[type=\"number\"] {\n" +
                "    width: 50px;\n" +
                "    margin-bottom: 10px;\n" +
                "}\n" +
                "</style>\n" +
                "</html>");
//        out.println(num1 + " " + op + " " + num2 + " = " + result);
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
