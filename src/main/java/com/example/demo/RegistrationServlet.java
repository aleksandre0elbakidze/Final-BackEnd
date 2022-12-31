package com.example.demo;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registrationServlet", value = "/registration-servlet")
public class RegistrationServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userName = request.getParameter(Constants.USERNAME);
        String name = request.getParameter(Constants.NAME);
        String lastName = request.getParameter(Constants.LASTNAME);
        String password = request.getParameter(Constants.PASSWORD);
        String passwordConfirm = request.getParameter(Constants.PASSWORDCONFIRM);
        String profession = request.getParameter(Constants.PROFESSION);
        DataBaseManager dataBaseManager = new DataBaseManager();

        try {
            User user = new User();
            user.setUsername(userName);
            user.setName(name);
            user.setLastName(lastName);
            user.setPassword(password);
            if (dataBaseManager.containsUser(user)) {
                // The username is not available, so display an error message and return
                RequestDispatcher dispatcher = request.getRequestDispatcher("regErrorUsername.jsp");
                request.setAttribute(Constants.USERNAME, userName);
                dispatcher.forward(request, response);
            } else if (password.equals(passwordConfirm)) {
                // Create a new User object with the specified name, username, and password
                dataBaseManager.register(user);
                request.setAttribute("name", user.getName());
                RequestDispatcher dispatcher = request.getRequestDispatcher("userpage.jsp");
                dispatcher.forward(request, response);
            } else {
                // The passwords do not match, so display an error message
                RequestDispatcher dispatcher = request.getRequestDispatcher("regErrorPassword.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            // Handle any exceptions that may be thrown by the dataBaseManager.containsUser or dataBaseManager.registerUser methods
            e.printStackTrace();
        }
    }
}
