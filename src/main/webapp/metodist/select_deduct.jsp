
<%--старница отчисления студента --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Успешное зачисление.</title>
    <link rel="stylesheet" href="w3.css">
</head>
<body class="w3-blue-gray">
Вберете студента:
<form action="/Select_student_deduct" method="post">

<select name="name5">
    <c:forEach var="name3" items="${name}">
        <option name="student_select" value=${name3.identificationNumberStudent}>${name3.identificationNumberStudent}.${name3.nameStudent}</option>
    </c:forEach>
</select>
${sts}

<button onclick="location.href='/enlistement.jsp'">зачислить еще!!!</button><br/>

<button onclick="location.href='/select_student_deduct.jsp'">отчислить студента </button><br/>
        </form>


</body>
</html>
