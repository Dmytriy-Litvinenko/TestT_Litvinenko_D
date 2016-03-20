<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <title>All</title>
</head>
<body>
<table width="600px">
  <tr>
    <td><b>Departments</b></td>
  </tr>
  <c:forEach var="department" items="${departments}">
    <tr>
      <td>${department.name}</td>
      <%--<td>${department.id}</td><td><a href="/emp?id=${department.id}">Employees</a> </td>--%>
      <form:form method="get" action="/dep/emp">
          <td><input type="hidden" name="depId" value="${department.id}"></td>
          <td><input type="submit"  value="Employees"/></td>
      </form:form>

        <td><a href="/depEdit?id=${department.id}">Edit</a> |
        <a href="/deleteDep?id=${department.id}">Delete</a></td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <a href="/depAdd">Add new department</a>
    </td>
  </tr>
</table>
</body>
</html>