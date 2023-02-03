package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        User user = getCreatedUser(req);
        req.setAttribute("user", user);
        Warehouse.getInstance().addUser(user);

        try {
            resp.sendRedirect("/add");
        } catch (IOException e) {
            e.getLocalizedMessage();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        } catch (IOException | ServletException e) {
            e.getLocalizedMessage();
        }
    }

    private User getCreatedUser(HttpServletRequest req) {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        return new User(firstName, lastName);
    }
}
