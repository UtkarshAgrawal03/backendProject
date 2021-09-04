<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Student record</title>
</head>
<body>
<form action="st_add">
Student Name:&nbsp<input type="text" placeholder="TYPE name" name="sname"><br><br>
Student Address:&nbsp<input type="text" placeholder="TYPE Address" name="saddress"><br><br>
Student Gender:&nbsp<input type="text" placeholder="TYPE M or F HERE" name="sgen"><br><br>
Student Contact:&nbsp<input type="number" placeholder="mobile number" name="scon"><br><br>
Student Class:&nbsp<input type="number" placeholder="Class" name="sclass"><br><br>
<input type="submit" value="ADD">
</form>
</body>
</html>