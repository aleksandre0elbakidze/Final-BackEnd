<%--
  Created by IntelliJ IDEA.
  User: Rog Strix
  Date: 12/29/2022
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Registration</title>
</head>
<body>
<h1>
  Please enter the matching password.
</h1>
<form action="registration-servlet">
  <label for="username">Username or email:</label><br>
  <input type="text" id="username" name="username"><br>
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="surname">Surname:</label><br>
  <input type="text" id="surname" name="surname"><br>
  <label for="password">Password:</label><br>
  <input type="password" id="password" name="password"><br>
  <label for="password-confirm">Confirm password:</label><br>
  <input type="password" id="password-confirm" name="password-confirm"><br><br>
  <label for="profession">Enter Your Profession:</label><br>
  <input type="profession" id="profession" name="profession"><br><br>
  <input type="submit" value="Sign up">
</form>
</body>
</html>