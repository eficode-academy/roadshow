<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Praqma Calculator</title>
</head>
<body>
	<form method="POST" action="Calculator">
		<input type="text" name="value" >
			
		<input type="submit" name="plus" value="+">
		<input type="submit" name="minus" value="-">
		<input type="submit" name="divide" value="/">
		<input type="submit" name="multiply" value="*">
		<br>
		<input type="text" name="result" readonly="readonly" value="<%if(request.getAttribute("value") != null){out.print(request.getAttribute("value"));} %>">
	</form>
	<br>
</body>
</html>