<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 07.11.2019
  Time: 7:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td><lable>Subject:</lable></td>
            <td><input name="subject"/></td>
        </tr>
        <tr>
            <td><lable>Date Complete:</lable></td>
            <td><input name="data_complete"/></td>
        </tr>
        <tr>
            <td><lable>Percent Complete:</lable></td>
            <td><input name="percent_compl"/></td>
        </tr>
        <tr>
            <td><lable>Type wokr:</lable></td>
            <td><input name="type_work"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Add"/></td>
            <td><input type="submit" value="Update"/></td>
        </tr>
    </table>
</form>
</body>
</html>
