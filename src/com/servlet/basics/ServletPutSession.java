package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/putSession")
public class ServletPutSession extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(true);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.print("<h1>"+ "Data has been added to session" +"</h1>");
	}
	
}
