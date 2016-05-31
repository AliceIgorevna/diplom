package com.epam.demennikova.fashion.web;

import com.epam.demennikova.fashion.constants.Path;
import com.epam.demennikova.fashion.daoIMP.DiscountService;
import com.epam.demennikova.fashion.daoIMP.TotalService;
import com.epam.demennikova.fashion.entity.Discount;
import com.epam.demennikova.fashion.entity.Total;
import com.epam.demennikova.fashion.entity.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

@WebServlet("/DiscountServlet")
public class DiscountAddServlet extends HttpServlet {
    private static final long serialVersionUID = 10505L;

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        UserData user = (UserData) request.getSession(false).getAttribute("loggedUser");

        int userDataId = user.getIdUserData();
        Total total = null;
        try {
            total = new TotalService().getAllTatalForUser(userDataId);
        } catch (Exception e1) {
            e1.printStackTrace();
        }


        if (total == null) {
            int productId = Integer.parseInt(request.getParameter("action"));
            int discountId = (new Random().nextInt(4) + 1);

            Discount disc = new DiscountService().getDiscountById(discountId);
            Date timeNow = new Date(Calendar.getInstance().getTimeInMillis());

            while (disc.getEndDate().before(timeNow)) {
                discountId = (new Random().nextInt(4) + 1);
                disc = new DiscountService().getDiscountById(discountId);
            }

            if (disc.getIdDiscount() == 0) {
                request.getSession(false).setAttribute("message", "Discount error!");
                response.sendRedirect(Path.HOME_PAGE_SERVLET);
                return;
            }


            request.getSession(false).setAttribute("informMessage", "Congratulation, your discount was generated!");
            request.getSession(false).setAttribute("discountAmountMessage", "The amount of your discount is: ");
            request.getSession(false).setAttribute("discountAmount", disc.getDiscountAmount());
            request.getSession(false).setAttribute("uniqHashMessage", "The uniq code of your discount is: ");
            request.getSession(false).setAttribute("uniqCode", disc.getUniqCode());

            try {
                new TotalService().addTotal(userDataId, discountId, productId);
            } catch (Exception e) {
            }
        } else {
            int discId = total.getDiscountId();
            request.getSession(false).setAttribute("informMessage", "Sorry, but you alresdy have a Discount!");
            request.getSession(false).setAttribute("discountAmountMessage", "The amount of your existing discount is: ");
            request.getSession(false).setAttribute("discountAmount", new DiscountService().getDiscountById(discId).getDiscountAmount());
            request.getSession(false).setAttribute("uniqHashMessage", "The uniq code of your discount is: ");
            request.getSession(false).setAttribute("uniqCode", new DiscountService().getDiscountById(discId).getUniqCode());
        }

        request.getRequestDispatcher(Path.DISCOUNT_FOR_USER).forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
    }

}
