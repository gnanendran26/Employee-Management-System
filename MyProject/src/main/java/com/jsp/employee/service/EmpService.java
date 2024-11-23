package com.jsp.employee.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.employee.entity.Employee;

public class EmpService {

	private static String url = "jdbc:mysql://localhost:3306/myproject";
	private static String user = "root";
	private static String password = "root";
	public static Connection con;
	public static PreparedStatement pstm;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public int saveEmployee(Employee emp) {
		
		String sql = "insert into employee values(?,?,?,?,?)";
		int num = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setInt(3, emp.getAge());
			pstm.setString(4, emp.getEmail());
			pstm.setDouble(5, emp.getSalary());
			
			num = pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return num ;
	}

	public List<Employee> displayEmployee() {
		
		List<Employee> list = new ArrayList<Employee>();
		
		String sql = "select * from employee";
		
		try {
			pstm=con.prepareStatement(sql);
			ResultSet set = pstm.executeQuery();
			
			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				int age = set.getInt(3);
				String email = set.getString(4);
				double salary = set.getDouble(5);
						
				list.add(new Employee(id, name, age, email, salary));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public int updateEmployee(Employee emp) {
		
		String sql="update employee set id=?, name=?, age=?, email=?, salary=? where id=?";
		int num=0;
		
		try {
			pstm=con.prepareStatement(sql);
			
			pstm.setInt(1, emp.getId());
			pstm.setString(2, emp.getName());
			pstm.setInt(3, emp.getAge());
			pstm.setString(4, emp.getEmail());
			pstm.setDouble(5, emp.getSalary());
			pstm.setInt(6, emp.getId());
			
			num=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
	}
	
	public int deleteEmployee(int emp) {
		
		String sql = "delete from employee where id=?";
		int num=0;
		
		try {
			pstm=con.prepareStatement(sql);
			
			pstm.setInt(1, emp);
			
			num=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return num;
		
	}
}
