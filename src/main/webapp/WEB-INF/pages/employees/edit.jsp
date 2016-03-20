<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/dep/empSave">
    <table>
        <tr>
            <td>firstName:</td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td>secondName:</td>
            <td><input type="text" name="secondName"/></td>
            <td><input type="hidden" name="depId" value="${depId}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>


