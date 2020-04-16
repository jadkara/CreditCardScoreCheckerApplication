<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CreditCard-Home Page</title>
</head>
<body bgcolor="#00FFFF">
<h1>Check for Credit Card Eligibility</h1>
	<form:form modelAttribute="pan" action="checkEligibility"
		method="post">
		<table border = "2">
			<tr>
				<td><form:label path="panNo">Enter PAN Number: </form:label></td>
				<td><form:input path="panNo" name="panNo" id="panNo" maxlength="10" 
				      pattern="[a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}" title="Please enter valid PAN number. E.g. AAAAA9999A" /></td>
			</tr>
			<tr>
				<td colspan="2" align="left"><form:button id="submit" name="check">Check</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>