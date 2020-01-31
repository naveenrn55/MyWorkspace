<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css" type="text/css">
<title>Employee Information</title>
</head>
<body>
	<form method="POST" action="EmployeeServlet">
		<div>
			<label>Enter Employee ID</label>
		</div>
		<div>
			<input type="text" name="employeeId"/>
		</div>
		<div>
			<input type="submit" value="Get Employee Information"/>
		</div>
	</form>
</body>
</html>