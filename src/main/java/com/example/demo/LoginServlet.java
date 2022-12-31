package com.example.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataBaseManager dataBaseManager = new DataBaseManager();
        User user = new User();
        String userName = request.getParameter(Constants.USERNAME);
        String password = request.getParameter(Constants.PASSWORD);
        user.setUsername(userName);
        user.setPassword(password);
        if (dataBaseManager.loginUser(user)) {
            // The username and password are correct, so forward to the user page
            request.setAttribute("name", user.getName());
            RequestDispatcher dispatcher = request.getRequestDispatcher("userpage.jsp");
            dispatcher.forward(request, response);
        } else {
            // The username and password are incorrect, so forward to the incorrect login page
            RequestDispatcher dispatcher = request.getRequestDispatcher("incorrectLogin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
