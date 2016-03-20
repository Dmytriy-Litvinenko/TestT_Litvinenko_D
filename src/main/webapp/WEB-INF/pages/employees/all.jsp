<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employees</title>
</head>
<body>

<table width="600px">
    <tr>
        <td><b>Employees</b></td>
    </tr>

    <c:forEach var="employee" items="${employees}">
    <tr>
        <td>${employee.firstName}</td>
        <td>${employee.secondName}</td>
            <%--<td>${employee.departmentId}</td><td></td></tr><tr>
        <td>${employee.id}</td>--%>
    </tr>
    <tr>
        <td><a href="/dep/empEdit?id=${employee.id}">Edit</a> |
            <a href="/dep/deleteEmp?id=${employee.id}">Delete</a></td>
    </tr>
    </c:forEach>
</table>
<form:form method="get" action="/dep/empAdd">
    <td><input type="hidden" name="depId" value="${depId}"></td>
    <td><input type="submit"  value="Add new employee"/></td>
    <%--<a href="/dep/empAdd?depId=${employees.get(0).departmentId}">Add new employee</a>--%>
</form:form>
</body>
</html>
