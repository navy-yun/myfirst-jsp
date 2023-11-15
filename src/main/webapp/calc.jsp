<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 자바 코드
    // request, response => 내장객체
    String op = request.getParameter("op");
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
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
%>
<%! // 선언부
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
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JSP 기초 - 심플 계산기</title>
</head>
<body>
<div id="container">
    <h3>Very Simple Calculator</h3>
    <form action="/calc.jsp" method="get">
        <div>
            <input type="number" name="num1">
            <select name="op">
                <option value="+">+</option>
                <option value="-">-</option>
                <option value="*">*</option>
                <option value="/">/</option>
            </select>
            <input type="number" name="num2">
        </div>
        <div>
            <input type="submit" value="="> <%=result%>
        </div>
    </form>
</div>
</body>
<style>
    html {
        height: 100%;
    }
    body {
        box-sizing: border-box;
        display: flex;
        align-items: center;
        justify-content: center;
        height: 60%;
    }
    h3 {
        margin-top: 0px;
        padding-top: 0px;
    }
    #container {
        border-style: solid;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        width: 300px;
        height: 150px;
    }
    input[type="number"] {
        width: 50px;
        margin-bottom: 10px;
    }
</style>
</html>
