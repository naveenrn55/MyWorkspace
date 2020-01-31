<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book a Vehicle</title>
<script type="text/javascript">
var xhr=new XMLHttpRequest();

function populateRegNo(selectedCategory)
{
	var selectedCat=selectedCategory.options[selectedCategory.selectedIndex].value;
	if(selectedCat!="-1")
		{
			var uri="getRegNo.action?category="+selectedCat;
			xhr.open("GET", uri);
			xhr.send();
			xhr.onreadystatechange=function()
			{
				if(xhr.readyState==4 && xhr.status==200)
					{
						document.getElementById("regNo").innerHTML=xhr.responseText;
					}
			};
			
		}else{
			document.getElementById("regNo").innerHTML="<select name=\"regNoList\"><option value=\"-1\">--SELECT--</option></select>";
		}
}
function getTotalRent(frm)
{
	var bookedFrom=frm.bookedFrom.value;
	var bookedTo=frm.bookedTo.value;
	var xhr1=new XMLHttpRequest();
	var regNo=frm.regNoList.options[frm.regNoList.selectedIndex].value;
	var uri="totalRent.action?bookedFrom="+bookedFrom+"&bookedTo="+bookedTo+"&regNo="+regNo;
	xhr1.open("GET", uri);
	xhr1.onreadystatechange=function()
	{
		if(xhr1.readyState==4 && xhr1.status==200)
			{
				document.getElementById("totalRent").value=xhr1.responseText;
			}
	};
	xhr1.send();
}
function validate(frm)
{
		
}
</script>
</head>
<body>
<div id="errMsg">
	${requestScope.errMsg }
</div>
	Book a Vehicle
	<form method="post" action="bookVehicle.action" onsubmit="return validate(this)">
		<table>
			<tr>
				<td>Customer Name:<input type="text" name="custName" /></td>
			</tr>
			<tr>
				<td>Category:<select name="category"
					onchange="populateRegNo(this)">
						<option value="-1">--SELECT--</option>
						<option value="Bus">Bus</option>
						<option value="Car">Car</option>
						<option value="Truck">Truck</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Vehicle Register Numbers:
					<div id="regNo">
						<select name="regNoList"><option value="-1">--SELECT--</option>
						</select>
					</div></td>
			</tr>
			<tr>
				<td>Booked From:<input type="text" name="bookedFrom" /></td>
			</tr>
			<tr>
				<td>Booked To:<input type="text" name="bookedTo" /></td>
			</tr>
			<tr>
				<td>Total Rent<input type="text" id="totalRent" name="totalRent" value=""
					onfocus="getTotalRent(this.form)" readonly="readonly"/>
				</td>
			</tr>
			<tr><td><input type="submit" value="Save" /></td></tr>
			<tr><td><input type="button" value="Cancel" /></td></tr>
		</table>
	</form>
</body>
</html>