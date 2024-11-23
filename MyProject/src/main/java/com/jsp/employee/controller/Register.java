package com.jsp.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.employee.entity.Employee;
import com.jsp.employee.service.EmpService;

@WebServlet("/register")
public class Register extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		double salary = Double.parseDouble(req.getParameter("salary"));
		
//		int ids = Integer.parseInt(id);
//		int ages = Integer.parseInt(age);
//		double sal = Double.parseDouble(salary);
		
		Employee emp = new Employee(id, name, age, email, salary);
		
		EmpService empService = new EmpService();
		int saveEmp = empService.saveEmployee(emp);
		
		if (saveEmp!=0) {
			
//			PrintWriter writer = resp.getWriter();
//			writer.print("<h3 style='text-align: center; color: green;'>--- EMPLOYEE REGISTRATION SUCCESSFUL ---</h3>");
			
//			resp.sendRedirect("Welcome.html");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("Welcome.html");
			dispatcher.forward(req, resp);
			
		} else {

			PrintWriter writer = resp.getWriter();
			writer.print("<h3 style='text-align: center; color: red;'>--- EMPLOYEE REGISTRATION UNSUCCESSFUL ---</h3>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("Register.html");
			dispatcher.include(req, resp);
			
		}
	}
}
