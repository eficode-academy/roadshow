<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script type="text/javascript" src="js/calculator_js.js"></script>
<title>Roadshow</title>
</head>
<h3>Calculator v. ${version}</h3>

<body>
	<form method="GET" action="Calculator">
        <input type="text" name="value" value="<%if(request.getParameter("load") != null && request.getSession().getAttribute("storedValue") != null){out.print(request.getSession().getAttribute("storedValue"));}%>"/>
        <button class="btn" type="submit" name="load">load</button>
        <button class="btn" type="submit" name="store">store</button>
		<button class="btn btn-success" type="submit" name="plus">+</button>
		<button class="btn" type="submit" name="minus">-</button>
        <button class="btn" type="submit" name="divide">/</button>
        <button class="btn" type="submit" name="multiply">*</button>
        <button class="btn" type="submit" name="modulo">%</button>
		<br>
        <input type="text" name="result" readonly="readonly" value="<%if(request.getAttribute("value") != null && request.getParameter("load") == null){out.print(request.getAttribute("value"));} %>">
	</form>
	<br>
</body>


</html>