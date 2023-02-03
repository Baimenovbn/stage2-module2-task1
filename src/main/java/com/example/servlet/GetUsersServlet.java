package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class GetUsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            super.doGet(req, resp);

            req.setAttribute("users", Warehouse.getInstance().getUsers());
            resp.sendRedirect("/users");
        } catch (ServletException | IOException ignored) {}
    }
}
