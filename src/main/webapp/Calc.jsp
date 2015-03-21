<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- Version and build information
http://stackoverflow.com/questions/1906266/maven-2-how-to-package-current-project-version-in-a-war-file
https://javadude.wordpress.com/2010/03/19/automatic-version-numbering-in-web-applications-with-hudson-part-1/
-->
<% 
java.util.jar.Manifest manifest = new java.util.jar.Manifest();
manifest.read(pageContext.getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
java.util.jar.Attributes attributes = manifest.getMainAttributes();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet"/>
<script type="text/javascript" src="js/calculator_js.js"></script>

<title><%=attributes.getValue("Implementation-AppName")%></title>
</head>
<h3>Calculator v. <%=attributes.getValue("Implementation-Version")%></h3>

<body>
	<form method="GET" action="Calculator">
        <input type="text" name="value"/>
        <button class="btn btn-success" type="submit" name="multiply">*</button>
		<button class="btn btn-inverse" type="submit" name="plus">+</button>
        <button class="btn btn-primary" type="submit" name="minus">-</button>
		<br>
        <input type="text" name="result" readonly="readonly" value="<%if(request.getAttribute("value") != null){out.print(request.getAttribute("value"));} %>">
	</form>
	<br>
</body>


</html>