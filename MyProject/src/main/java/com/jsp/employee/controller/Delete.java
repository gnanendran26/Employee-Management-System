package com.jsp.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.employee.service.EmpService;

@WebServlet("/delete")
public class Delete extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		EmpService empService = new EmpService();
		int deleteEmp = empService.deleteEmployee(id);

		if (deleteEmp != 0) {

			RequestDispatcher dispatcher = req.getRequestDispatcher("display");
			dispatcher.forward(req, resp);

		} else {

			PrintWriter writer = resp.getWriter();
			writer.print("<h3 style='text-align: center; color: red;'>--- EMPLOYEE DELETION UNSUCCESSFUL ---</h3>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("Delete.html");
			dispatcher.include(req, resp);

		}

	}
}
