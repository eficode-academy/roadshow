<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Praqma Calculator</title>
</head>
<body>
	<form method="POST" action="Calculator">
		<input type="text" name="value"/>
        <input type="submit" name="load" value="load"/>
        <input type="submit" name="store" value="store"/>
		<input type="submit" name="plus" value="+"/>
		<input type="submit" name="minus" value="-"/>
		<input type="submit" name="divide" value="/"/>
		<input type="submit" name="multiply" value="*"/>
		<br>
		<input type="text" name="result" readonly="readonly" value="<%if(request.getAttribute("value") != null){out.print(request.getAttribute("value"));} %>">
	</form>
	<br>
</body>
</html>