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

@WebServlet("/update")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		double salary = Double.parseDouble(req.getParameter("salary"));

		Employee emp = new Employee(id, name, age, email, salary);
		
		EmpService empService = new EmpService();
		int updateEmp = empService.updateEmployee(emp);
		
		if (updateEmp!=0) {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("display");
			dispatcher.forward(req, resp);
			
		} else {

			PrintWriter writer = resp.getWriter();
			writer.print("<h3 style='text-align: center; color: red;'>--- EMPLOYEE UPDATION UNSUCCESSFUL ---</h3>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("Update.html");
			dispatcher.include(req, resp);
			
		}
		
	}
}
