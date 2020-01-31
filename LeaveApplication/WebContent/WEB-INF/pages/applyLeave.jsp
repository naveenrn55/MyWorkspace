<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply for Leave</title>
</head>
<body>
<form:form action="addLeave.action" commandName="leave">
	Leave Type:<form:select path="leaveType.leaveTypeId"
		items="${leaveTypeList}" itemLabel="leaveType" itemValue="leaveTypeId" />
	<br />
	Employee Name:<form:select path="employee.ssn" items="${employeeMap}" />
	<br />
	Start Date:<form:input path="startDate" />
	<br />
	End date<form:input path="endDate" />
	<br />
	Number of days:<form:input path="noOfDays" />
	<br />
	<input type="submit" value="Apply" />
	<input type="button"  value="Cancel" onclick="window.location.href='index.jsp'" />
</form:form>
</body>
</html>