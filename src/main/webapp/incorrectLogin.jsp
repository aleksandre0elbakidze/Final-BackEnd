<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
  <h1>
      Either username or password was incorrect, please try again
  </h1>
<form action="login-servlet">
    <label for="username">Enter Username or email:</label><br>
    <input type="text" id="username" name="username"><br>
    <label for="password">Enter Password:</label><br>
    <input type="password" id="password" name="password"><br><br>
    <input type="submit" value="Sign in">
</form>
   <a href=registration.jsp>Not registered yet?</a>
</body>
</html>