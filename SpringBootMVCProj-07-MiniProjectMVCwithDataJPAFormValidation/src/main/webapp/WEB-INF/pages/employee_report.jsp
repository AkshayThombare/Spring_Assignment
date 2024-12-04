<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Employee Report</title>
</head>
<body>
<c:choose>
<c:when test="${!empty empList}">
<table align="center"border=2 bgcolor="cyan">
<tr bgcolor=pink><th>EmpNo</th><th>EmpName</th><th>Job</th><th>Salary</th><th>DeptNo</th><th>Operation</th></tr>

<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.eno}</td> 
<td>${emp.ename}</td>
<td>${emp.job}</td>
<td>${emp.sal}</td>
<td>${emp.deptno}</td>
<td><a href="edit_employee?eno=${emp.eno}">Edit </a></td>
<td><a href="delete_employee?eno=${emp.eno}" onclick="Confirm('Do You Want To Delete')"> Delete</a></td></tr>
</c:forEach>
</table>

</c:when>


<c:otherwise>
<h2 style="color:red;text-align:center">No Records Found</h2>
</c:otherwise>
</c:choose>
<br>
<h1 style="color:blue;text-align:centre"> <br>${result} </h1>

<h2 style="text-align:center;color:green"><a href="insert_employee">Add Employee</a></h2>
<h2 style="text-align:center;color:Red"><a href="./">Home</a></h2>
</body>
</html>