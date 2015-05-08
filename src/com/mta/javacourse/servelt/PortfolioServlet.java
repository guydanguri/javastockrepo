package com.mta.javacourse.servelt;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PortfolioManager.protfoliomanger;

import com.mta.javacourse.model.Portfolio;
/**
 * 
 * this class is the servlet of the project
 *
 */

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		protfoliomanger protfoliomanger = new protfoliomanger();
		Portfolio protfolio = protfoliomanger.getPortfolio();
		
		Portfolio protfolio2 =  new  Portfolio(protfolio);
		protfolio2.setTitle("Portfolio #2");
		
		resp.getWriter().println(protfolio.getHtmlString());
		resp.getWriter().println("<br>");
		resp.getWriter().println(protfolio2.getHtmlString());
		
		protfolio.removeStock(protfolio.getStocks()[0].getsymbol());
		
		resp.getWriter().println(protfolio.getHtmlString());
		resp.getWriter().println("<br>");
		resp.getWriter().println(protfolio2.getHtmlString());
		
		protfolio2.getStocks()[2].setbid((float) 55.55);
		
		resp.getWriter().println(protfolio.getHtmlString());
		resp.getWriter().println("<br>");
		resp.getWriter().println(protfolio2.getHtmlString());
		
		
	}

}
