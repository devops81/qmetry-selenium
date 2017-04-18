<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="dateValue" class="java.util.Date" />
<jsp:setProperty name="dateValue" property="time" value="${timestamp}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Build info</title>
</head>
<body>
<table>
<tr>
    <td>Build time: </td>
    <td><fmt:formatDate value="${dateValue}" pattern="dd.MM.yyyy HH:mm:ss" /></td>
</tr>
<tr>
    <td>Build number: </td>
    <td>${buildNumber}</td>
</tr>
<tr>
    </tr>
</table>
</body>
</html>
