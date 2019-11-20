<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
  Created by IntelliJ IDEA.
  User: Роман
  Date: 06.11.2019
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Laba04</title>
    <style>
      table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 14px;
        border-radius: 10px;
        border-spacing: 0;
        text-align: center;
      }
      th {
        background: #BCEBDD;
        color: white;
        text-shadow: 0 1px 1px #2D2020;
        padding: 10px 20px;
      }
      th, td{
        border-style: solid;
        border-width: 0 1px 1px 0;
        border-color: white;
      }
      th:first-child, td:first-child {
        text-align: left;
      }
      th:first-child {
        border-top-left-radius: 10px;
      }
      th:last-child{
        border-top-right-radius: 10px;
        border-right: none;
      }
      td{
        padding: 10px 20px;
        background: #F8E391;
      }
      tr:last-child td:first-child {
        border-radius: 0 0 0 10px;
      }
      tr:last-child, td:last-child{
        border-radius: 10px 0 10px 0;
      }
      tr td:last-child {
        border-right: none;
      }
    </style>
  </head>
  <body>
  <table>
    <tr>
      <td>Subject</td>
      <td>Date Complete</td>
      <td>Percent</td>
      <td>Type of work</td>
    </tr>
    <c:forEach var="complete" items="${requestScope.works}">
      <tr>
        <td><c:out value="${complete.subject}"/> </td>
        <td><c:out value="${complete.data_complete}"/> </td>
        <td><c:out value="${complete.percent_compl}"/> </td>
        <td><c:out value="${complete.type_work}"/> </td>
      </tr>
    </c:forEach>

  </table>
  <a href='<c:url value="/AddUser" />'>Add Task</a>
  </body>
</html>
