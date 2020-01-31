package com.mindtree.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mindtree.entity.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<Integer, Employee> employeeMap = new HashMap<Integer, Employee>();
	
	@Override
	public void init() throws ServletException {
		employeeMap.put(100, new Employee(100,"Rajesh","rajesh_kumar@mindtree.com","Accounts"));
		employeeMap.put(101, new Employee(101,"Paresh","paresh_desai@mindtree.com","TTG"));
		employeeMap.put(102, new Employee(102,"kavitha","kavitha_prakash@mindtree.com","Marketing"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String strEmployeeId =  request.getParameter("employeeId") ;
		if( strEmployeeId != null ){
			int employeeId = Integer.parseInt(strEmployeeId);
			if(employeeMap.containsKey(employeeId)){
				request.setAttribute("employee", employeeMap.get(employeeId));
			} 
		}
	 RequestDispatcher dispatcher = 
	 			 request.getRequestDispatcher("EmployeeInfo.jsp");
		dispatcher.forward(request, response);  
	  
 	//response.sendRedirect("EmployeeInfo.jsp");
		 
	}

}
