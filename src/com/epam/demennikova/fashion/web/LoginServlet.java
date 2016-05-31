package com.epam.demennikova.fashion.web;

import com.epam.demennikova.fashion.constants.Path;
import com.epam.demennikova.fashion.constants.RequestConstants;
import com.epam.demennikova.fashion.daoIMP.ProductService;
import com.epam.demennikova.fashion.daoIMP.UserDataService;
import com.epam.demennikova.fashion.entity.Product;
import com.epam.demennikova.fashion.entity.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 102030405L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = null;
		HttpSession session = request.getSession();
		try {
			products = new ProductService().getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String email = request.getParameter("email"); // ��������� ����
		String password = request.getParameter("password");
		UserData user = new UserDataService().getUserByEmailPassword(email, password);
		if (user != null) {
			session.setAttribute("loggedUser", user);
			session.setAttribute("items", products);
			response.sendRedirect(Path.PRODUCTS_SERVLET);
		} else {
			session.setAttribute("errorMessage", "There is no such user");
			response.sendRedirect(request.getHeader(RequestConstants.REQUEST_HEADER));
			return;
		}
	}

}
