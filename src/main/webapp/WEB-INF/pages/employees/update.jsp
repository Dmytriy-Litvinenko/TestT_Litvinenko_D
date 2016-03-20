<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/dep/empUpdate">

    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"  placeholder="${employee.firstName}"/></td>
        <tr>
        </tr>
            <td>Surname:</td>
            <td><input type="text" name="surname"  placeholder="${employee.secondName}"/></td>
            <td><input type="hidden" name="depId" value="${depId}"></td>
            <td><input type="hidden" name="id" value="${employee.id}"></td>
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
