<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DashBoard</title>
</head>
<body>
<%
//HttpSession session=request.getSession();
if(session.getAttribute("uname")==null)
{
	response.sendRedirect("login_page.jsp");
}
%>
<h1>WELCOME USER</h1>
<a href="http://localhost:8081/project_phase_2/Assignment.jsp"><input type ="button" value="To Update record click here"></a>
<a href="http://localhost:8081/project_phase_2/Display.jsp"><input type ="button" value="For look up click here"></a><br><br><br><br><br><br>
<form action="logout">
<input type="submit" value="Log Me out"><br><br><br><br><br><br>
</form>
</body>
</html>