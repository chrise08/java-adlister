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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/")
public class IndexServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get all the burgers that exist currently, and list them here
		// with links to their individual product pages
		McBurgers burgerDao = DaoFactory.getMcBurgersDao();
		
		// find the burgers, 1 by 1, and add them to the ArrayList, to send
		// to the JSP
		List<McBurger> allBurgers = new ArrayList<>();
		allBurgers.add(burgerDao.findById(1));
		allBurgers.add(burgerDao.findById(2));
		allBurgers.add(burgerDao.findById(3));
		
		request.setAttribute("allBurgers", allBurgers);
		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}
}
