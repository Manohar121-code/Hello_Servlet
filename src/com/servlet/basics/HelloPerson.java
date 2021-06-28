package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloPerson")
public class HelloPerson extends HttpServlet {

	String msg;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		msg = "Hello "+ name;
		pw.print("<h1>"+ msg +"</h1>");
	}
	
	public void destroy() {
		//some code
	}
	
}
