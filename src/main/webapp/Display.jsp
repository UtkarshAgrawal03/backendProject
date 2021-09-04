<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>
<%
//HttpSession session=request.getSession();
if(session.getAttribute("uname")==null)
{
	response.sendRedirect("login_page.jsp");
}
%>
<a href="St_disp.jsp"><input type ="button" value="To Display Student Details click here"></a><br><br>
<a href="class_disp.jsp"><input type ="button" value="To Display Class details click here"></a><br><br>
<a href="Teacher_disp.jsp"><input type ="button" value="To Display Teacher details click here"></a><br><br>
<a href="Sub_disp.jsp"><input type ="button" value="To Display Subject details click here"></a><br><br>
<a href="Assign_disp"><input type ="button" value="To  Display Assigned teacher details  click here"></a><br><br>




</body>
</html>