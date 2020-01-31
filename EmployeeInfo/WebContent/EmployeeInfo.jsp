<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.mindtree.entity.Employee"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Employee Details</title>
</head>
<body>
	<h1>Employee Details</h1>
	 
	Employee ID: <%= request.getParameter("employeeId") %> <br />
	<%
		Employee employee = (Employee) request.getAttribute("employee");
		if(employee == null) {
	%>
		Employee Does not exist !!
	<%
		} else {
	%>
	Employee Name : <%= employee.getEmployeeName() %> <br />
	Employee Email : <%= employee.getEmail() %> <br />
	Department : <%= employee.getDepartmentName() %> <br />
	<%
		}
	%> 
</body>
</html>