package com.epam.demennikova.fashion.web;

import com.epam.demennikova.fashion.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import java.sql.Date;


@WebServlet(name = "registrationPageServlet", urlPatterns = "/registrationPageServlet")
public class RegistrationPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1342554467L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Path.REGISTRATION_PAGE).forward(request, response);

    }

}