package com.mta.javacourse;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03Servlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setContentType("text/html");
			
			
	   
	   int cradius = 50;
	   double area = cradius * cradius * Math.PI;
	   String line1 = new String("calculation 1: Area of circle with this " + cradius + " is " + area + " square cm ");
	   
	   
	   int hypotenuse = 50;
	   double angleB = 30;
	   double angleBradians = Math.toRadians(angleB);
	   double opposite = Math.sin(angleBradians)*hypotenuse;
	   String line2 = new String("calculation 2: Length of opposite where angle B is " + angleB + " and hypotenuse is " + hypotenuse + " is " + opposite);
	  

	   int base = 20;
	   int exp = 13;
	   long power = (long) Math.pow(base, exp);
	   
	   String line3 = new String("calculation 3: Power of " + base + " with exp of " + exp + " is " + power);

	   String resultStr = line1 + "<br>" + line2 + "<br>" + line3;
	   resp.getWriter().println(resultStr);	
	}
			
}
