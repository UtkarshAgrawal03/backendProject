<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Updation page</title>
</head>
<body>
<%
//HttpSession session=request.getSession();
if(session.getAttribute("uname")==null)
{
	response.sendRedirect("login_page.jsp");
}
%>
<a href="Stud_add.jsp"><input type ="button" value="To Add Student click here"></a><br><br>
<a href="Re_stud.jsp"><input type ="button" value="To remove Student record click here"></a><br><br>
<a href="Class_add.jsp"><input type ="button" value="To Add Class click here"></a><br><br>
<a href="Re_class.jsp"><input type ="button" value="To remove Class record click here"></a><br><br>
<a href="Teacher_add.jsp"><input type ="button" value="To Add Teacher click here"></a><br><br>
<a href="Re_teacher.jsp"><input type ="button" value="To remove Teacher record click here"></a><br><br>
<a href="sub_add.jsp"><input type ="button" value="To Add Subject click here"></a><br><br>
<a href="Re_sub.jsp"><input type ="button" value="To remove Subject record click here"></a><br><br>
<a href="AssignAdd.jsp"><input type ="button" value="To Assign teacher  click here"></a><br><br>
<a href="Assign_remove.jsp"><input type ="button" value="To retract teacher click here"></a><br><br>


</body>
</html>