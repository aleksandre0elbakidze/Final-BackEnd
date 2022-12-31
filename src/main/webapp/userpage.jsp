<%@ page import="com.example.demo.Constants" %><%--
  Created by IntelliJ IDEA.
  User: Rog Strix
  Date: 12/26/2022
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
</head>
<h1>
    Welcome, <%= request.getAttribute("name") %>!
</h1>
<br>
<br>
<a href=index.jsp>sign out</a>
</body>
</html>
