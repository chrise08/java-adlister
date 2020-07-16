package controllers;

import models.DaoFactory;
import models.McBurger;
import models.McBurgers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowBurgerServlet", urlPatterns = "/burgers/show")
public class ShowBurgerServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	                                                                                      IOException {
		// check for the burger ID attribute in the URL
		long burgerId = Long.parseLong(request.getParameter("id"));
		
		// create a connection to the DaoFactory
		McBurgers burgerDao = DaoFactory.getMcBurgersDao();
		
		// get the burger by its ID, using findById
		McBurger thisBurger = burgerDao.findById(burgerId);
		
		// send that burger back to the JSP
		request.setAttribute("burger", thisBurger);
		request.getRequestDispatcher("/WEB-INF/view/burgers/burgers-show.jsp").forward(request, response);
	}
}
