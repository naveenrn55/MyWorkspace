<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approve Leave</title>
</head>
<body>

<form method="get" action="getAllLeaves.action">
	<select name="manager">
		<c:forEach items="${requestScope.managerList}" var="emp">
			<option value="${emp.ssn}">${emp.firstName} ${emp.lastName }</option>
		</c:forEach>
	</select><br/>
	<input type="submit" value="Approve">
</form>
</body>
</html>