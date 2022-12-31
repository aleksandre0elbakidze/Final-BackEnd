<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>
        Fill in your information to register
    </h1>
    <form action="registration-servlet">
        <label for="username">Username or email:</label><br>
        <input type="text" id="username" name="username"><br>
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="lastname">Surname:</label><br>
        <input type="text" id="lastname" name="lastname"><br>
        <label for="password">Password:</label><br>
        <input type="password" id="password" name="password"><br>
        <label for="password_confirm">Confirm password:</label><br>
        <input type="password" id="password_confirm" name="password_confirm"><br><br>
        <label for="profession">Enter Your Profession:</label><br>
        <input type="profession" id="profession" name="profession"><br><br>
        <input type="submit" value="Sign up">
    </form>
</body>
</html>
