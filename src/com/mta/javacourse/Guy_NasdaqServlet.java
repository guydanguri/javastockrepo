package com.mta.javacourse;
import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Guy_NasdaqServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
	
		int num1,num2,num3;
		num1=3;
		num2=4;
		num3=7;
		
		int result= (num1+num2)*num3;
		
		String resultstr= new String(("<h1>Result of ("+num1+"+"+num2+")"+"*"+num3+"="+result+"</h1>"));
		
		resp.getWriter().println(resultstr);
		
	}
}

