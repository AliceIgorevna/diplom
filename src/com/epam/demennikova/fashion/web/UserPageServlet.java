package com.epam.demennikova.fashion.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import com.epam.demennikova.fashion.daoIMP.UserDataService;

@WebServlet("/UserPage")
public class UserPageServlet extends HttpServlet{

	private UserDataService userDao = new UserDataService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		req.setAttribute("x1", "hi, all");
	}
	
}
