package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SavePerson")
public class InsertPerson extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//insert person
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String userName = "root";
		String password = "manah";
		
		String name = request.getParameter("name");
		String salaryStr = request.getParameter("salary");
		int salary = Integer.parseInt(salaryStr);
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			String sql = "insert into person(name, salary) values(?, ?)";
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, salary);
			
			prepareStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && prepareStatement != null) {
					connection.close();
					prepareStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String msg = "Person data inserted successfully";
		pw.print("<h1>"+ msg +"</h1>");
	}
	
	public void destroy() {
		//some code
	}
	
}
