package com.epam.demennikova.fashion.web;

import com.epam.demennikova.fashion.constants.Path;
import com.epam.demennikova.fashion.constants.RequestConstants;
import com.epam.demennikova.fashion.dao.UserDataDao;
import com.epam.demennikova.fashion.daoIMP.UserDataService;
import com.epam.demennikova.fashion.entity.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//import java.sql.Date;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1342554467L;
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String CONFIRM_PASSWORD = "confirmPassword";
	public static final String BIRTH_DATE = "birthDate";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter(EMAIL);
		String password = request.getParameter(PASSWORD);
		String confirmPassword = request.getParameter(CONFIRM_PASSWORD);
		String birthDate = request.getParameter(BIRTH_DATE);
		if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || birthDate.isEmpty()){
			response.sendRedirect(request.getHeader(RequestConstants.REQUEST_HEADER));// �������������� �� �� �� ��������
		}
		
		UserData user = new UserData();
		user.setEmail(email);
		user.setPassword(password);
		user.setBirthDate(java.sql.Date.valueOf(birthDate));

		UserDataDao dao = new UserDataService();
		
		if(!password.equals(confirmPassword)) {
			session.setAttribute("errorMessage", "Passwords are not the same");
			response.sendRedirect(request.getHeader(RequestConstants.REQUEST_HEADER));
			return;
		}

		if(!dao.addUser(email, password, user.getBirthDate())) {
			session.setAttribute("errorMessage", "Email is already exists");
			response.sendRedirect(request.getHeader(RequestConstants.REQUEST_HEADER));
			return;
		}
		
		user = dao.getUserByEmailPassword(user.getEmail(), user.getPassword());
		session.setAttribute("loggedUser", user);// �������� � ������ ���� :)
		response.sendRedirect(Path.PRODUCTS_SERVLET);

	}

}
