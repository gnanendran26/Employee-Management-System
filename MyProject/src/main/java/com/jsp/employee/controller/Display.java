package com.jsp.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.employee.entity.Employee;
import com.jsp.employee.service.EmpService;

@WebServlet("/display")
public class Display extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpService empService = new EmpService();
		List<Employee> displayEmployee = empService.displayEmployee();
		
		PrintWriter writer = resp.getWriter();
		String empData="";
		
		for (Employee emp : displayEmployee) {
			empData+=" <tr>\r\n"
					+ "                <td>"+emp.getId()+"</td>\r\n"
					+ "                <td>"+emp.getName()+"</td>\r\n"
					+ "                <td>"+emp.getAge()+"</td>\r\n"
					+ "                <td>"+emp.getEmail()+"</td>\r\n"
					+ "                <td>"+emp.getSalary()+"</td>\r\n"
					+ "                <td><a href=\"Update.html\"><button class=\"update-btn\">Update</button></a> <a href=\"Delete.html\"><button class=\"delete-btn\">Delete</button></a></td>\r\n"
					+ "            </tr>";
		}
		
		writer.print("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Employee Table</title>\r\n"
				+ "    <style>\r\n"
				+ "        body {\r\n"
				+ "            font-family: Arial, sans-serif;\r\n"
				+ "            background-color: #f4f4f4;\r\n"
				+ "            margin: 0;\r\n"
				+ "            padding: 20px;\r\n"
				+ "            display: flex;\r\n"
				+ "            justify-content: center;\r\n"
				+ "            align-items: center;\r\n"
				+ "            height: 100vh;\r\n"
				+ "        }\r\n"
				+ "        table {\r\n"
				+ "            width: 80%;\r\n"
				+ "            border-collapse: collapse;\r\n"
				+ "            background-color: #fff;\r\n"
				+ "            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\r\n"
				+ "            border: 1px solid #ddd;\r\n"
				+ "        }\r\n"
				+ "        th, td {\r\n"
				+ "            padding: 12px 15px;\r\n"
				+ "            text-align: center;\r\n"
				+ "            border: 1px solid #ddd;\r\n"
				+ "        }\r\n"
				+ "        th {\r\n"
				+ "            background-color: #007BFF;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "        tr:nth-child(even) {\r\n"
				+ "            background-color: #f9f9f9;\r\n"
				+ "        }\r\n"
				+ "        button {\r\n"
				+ "            padding: 8px 12px;\r\n"
				+ "            font-size: 14px;\r\n"
				+ "            border: none;\r\n"
				+ "            border-radius: 5px;\r\n"
				+ "            cursor: pointer;\r\n"
				+ "        }\r\n"
				+ "        .update-btn {\r\n"
				+ "            background-color: #28a745;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "        .delete-btn {\r\n"
				+ "            background-color: #dc3545;\r\n"
				+ "            color: white;\r\n"
				+ "        }\r\n"
				+ "        button:hover {\r\n"
				+ "            opacity: 0.8;\r\n"
				+ "        }\r\n"
				+ "        a {\r\n"
				+ "            text-decoration: none;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <table>\r\n"
				+ "        <thead>\r\n"
				+ "            <tr>\r\n"
				+ "                <th>ID</th>\r\n"
				+ "                <th>NAME</th>\r\n"
				+ "                <th>AGE</th>\r\n"
				+ "                <th>E-MAIL</th>\r\n"
				+ "                <th>SALARY</th>\r\n"
				+ "                <th>MODIFY</th>\r\n"
				+ "            </tr>\r\n"
				+ "        </thead>\r\n"
				+ "        <tbody>\r\n"
				+             empData
				+ "        </tbody>\r\n"
				+ "    </table>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
	}
	
}
