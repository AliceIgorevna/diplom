package com.epam.demennikova.fashion.web;

import com.epam.demennikova.fashion.constants.Path;
import com.epam.demennikova.fashion.daoIMP.ProductService;
import com.epam.demennikova.fashion.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "products", urlPatterns = "/products")
public class ProductPageServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = null;
        try {
            products = new ProductService().getAllProducts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("items", products);
        request.getRequestDispatcher(Path.SERVICE_PAGE).forward(request, response);
    }

}
