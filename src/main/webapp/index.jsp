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
<!DOCTYPE html PUBLIC">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><%=attributes.getValue("Implementation-AppName")%></title>
    </head>
    <body>
        <h1><%=attributes.getValue("Implementation-AppName")%> v. <%=attributes.getValue("Implementation-Version")%></h1>
        <p>
            <a href="Calculator">Link to the calculator</a>
        </p>
        <div style="width:70%; display:block; float:left;">
            <img src="images/eq_display.png" style="float:left; margin-left:20px;"/>
         </div>
         <div style="width:30%; display:block; float:left;">
            <h2>Info</h2>
            <ol>
                <li>AppName: <%=attributes.getValue("Implementation-AppName")%></li>
                <li>TrainingUserName: <%=attributes.getValue("Implementation-TrainingUserName")%></li>
                <li>DeployPath: <%=attributes.getValue("Implementation-DeployPath")%></li>
                <li>GitVersion: <%=attributes.getValue("Implementation-GitVersion")%></li>
                <li>Version: <%=attributes.getValue("Implementation-Version")%></li>
                <li>GitRepoUrl: <%=attributes.getValue("Implementation-GitRepoUrl")%></li>
            </ol>
        </div>
    </body>
</html>