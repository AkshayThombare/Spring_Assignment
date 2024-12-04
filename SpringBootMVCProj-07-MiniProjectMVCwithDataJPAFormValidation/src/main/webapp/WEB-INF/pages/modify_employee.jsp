<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Employee</title>
</head>
<body>
<form:form modelAttribute="emp">

<%-- <p style="color:red;text-align:center">
<form:errors path="*"/>
</p> --%>

<table align="center" border="1" bgcolor="cyan">
<tr>
<td> Employee No </td>
<td><form:input path="eno" readonly="true"/></td>
</tr>
<tr>
<td> Employee Name </td>
<td><form:input path="ename"/><form:errors path="ename" cssStyle="color:red"/></td>
</tr>
<tr>
<td>Employee Job</td>
<td><form:input  path="job" /><form:errors path="job" cssStyle="color:red"/></td>
</tr>
<tr>
<td>Employee Salary</td>
<td><form:input path="sal"/><form:errors path="sal" cssStyle="color:red"/></td>
</tr>
<tr>
<td>Employee DeptNo</td>
<td><form:input path="deptno"/><form:errors path="deptno" cssStyle="color:red"/></td>
</tr>
<tr>
<td></td>
<td><input type="submit" name="Submit"><button type="reset" name="reset" >Cancel</button></td>

</tr>
</table>
</form:form>
</body>
</html>