<%--
  Created by IntelliJ IDEA.
  User: dima
  Date: 13.03.16
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/depUpdate">

    <table>
        <tr>
            <%--<td>${department.id}</td>
            <td>${department.name}</td>--%>
            <td>name:</td>
            <td><input type="text" name="name"  placeholder="${department.name}"/></td>
            <td><input type="hidden" name="id" value="${department.id}"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"  />
            </td>
        </tr>

    </table>
</form:form>
</body>
</html>





