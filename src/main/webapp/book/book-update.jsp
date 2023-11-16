<%@ page import="com.kitri.jspbasic.book.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Book book = (Book) request.getAttribute("book");%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<form class="book" action="/book/updated/<%=book.getId()%>" method="get">
    <div class="flex-item">
        <label for="name">제목</label>
        <input type="text" name="name" id="name" value="<%=book.getName()%>">
    </div>
    <div class="flex-item">
        <label for="author">저자</label>
        <input type="text" name="author" id="author" value="<%=book.getAuthor()%>">
    </div>
    <div class="flex-item">
        <label for="publishedDate">출간일</label>
        <input type="date" name="publishedDate" id="publishedDate" value="<%=book.getPublishedDate()%>">
    </div>
    <input class="flex-item" type="submit" id="register" value="수정하기">
</form>
</body>
</html>
