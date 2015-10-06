package com.gft.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ddph on 06/10/2015.
 */
@WebServlet(
        name = "phoneBookController",
        urlPatterns = {"/main"}
)
public class phoneBookController extends HttpServlet {
    public phoneBookController() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/indexx.jsp");
        requestDispatcher.forward(request, response);
    }
}
