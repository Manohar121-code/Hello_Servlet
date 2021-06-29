package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getSession")
public class ServletGetSession extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Object firstName = session.getAttribute("firstName");
		Object lastName = session.getAttribute("lastName");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h1>"+ "Below data has been retrieved from session" +"</h1>");
		pw.print("<h1>"+ firstName+" - "+ lastName +"</h1>");
//		session.invalidate();
	}
	
}
