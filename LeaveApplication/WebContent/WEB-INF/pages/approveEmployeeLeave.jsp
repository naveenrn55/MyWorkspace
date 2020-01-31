<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Employee Leave</title>
</head>
<body>
<form action="approveLeaveForEmployee.action" >
	<c:forEach items="${requestScope.employeeMap}" var="emp">
		<input type="checkbox" name="leaveId" value="${emp.key }"/>${emp.value }<br/>
	</c:forEach>
	<input type="submit" value="Approve all" />
</form>
</body>
</html>