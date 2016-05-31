package com.epam.demennikova.fashion.web;

import com.epam.demennikova.fashion.constants.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "projects", urlPatterns = "/projects")
public class ProjectsPageServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Path.PROJECTS).forward(request, response);
    }

}
