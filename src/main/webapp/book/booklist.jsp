<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.kitri.jspbasic.book.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="java.io.IOException" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>도서관리 프로그램</title>
</head>
<body>
<h3>도서관리 프로그램</h3>
<div id="container">
<%--    <div class="book"> 제목 : 저자 : 출판일 <a href="/book-update">수정</a> <a href="/book-delete">삭제</a></div>--%>
<%--    <div class="book"> 제목 : 저자 : 출판일 <a href="/book-update">수정</a> <a href="/book-delete">삭제</a></div>--%>
    <%
        if (application.getAttribute("books") != null) {
            List<Book> books = (List<Book>) application.getAttribute("books");
            for (Book book : books) {
                out.println("<div class=\"book\">");
                out.print(book.getName() + "&nbsp");
                out.print(book.getAuthor() + "&nbsp");
                out.print(book.getPublishedDate() + "&nbsp");
                out.println("<a href=\"/book/update/" +  book.getId() + "\">수정</a>&nbsp<a href=\"/book/remove/" + book.getId() + "\">삭제</a></div>");
            }
        }
    %>
</div>
    <button style="width: 80px; height: 25px">
        <a href="/book/book-register.html" style="text-decoration:none; color: black">등록하기</a>
    </button>
</body>
<style>
html {
    height: 100%;
}
body {
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100%;
}
h3 {
    margin-top: 0px;
    padding-top: 0px;
    height: 10%;
}
#container {
    width: 50%;
    height: 70%;
}
form {
    height: 10%;
}
input[type="number"] {
    width: 50px;
    margin-bottom: 10px;
}
.book {
    padding: 3px 3px;
    border-style: solid;
}
</style>
</html>