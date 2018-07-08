<%--поиск студента --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Поиск студента.  </title>
</head>
<body>
Выберете студента из списка:    <form action="/Info_student" method="post">
    <select name="student">
        <c:forEach var="list_student" items="${list_students}">
            <option name="selection" value=${list_student.identificationNumberStudent}>${list_student.identificationNumberStudent}${list_student.surnameStudent} ${list_student.nameStudent} ${list_student.patronymicStudent}</option>
        </c:forEach>
    </select>
    <button onclick="location.href='/metodist/info_student.jsp'" >Показать информацию</button>
    <%--<input type="submit" name="selects" value="byjaj">--%>

</form><br/>

Или выберите группу:

<form action="/Existing_groups" method="post">
    <select name="grade_list">
        <c:forEach var="list_grades" items="${list_grade}">

            <option value=${list_grades}>${list_grades}</option>
        </c:forEach>
    </select>

<button onclick="location.href='/metodist/student_in_grade.jsp'">показать студентов группы</button>

</form>

<%--<p>--%>

<%--<form action="/Info_student" method="post">--%>
<%--<c:forEach var="list_student" items="${list_students}">--%>
<%--<a name="selection1" value="${list_student.identificationNumberStudent}"onclick="location.href='/metodist/info_student.jsp'" >${list_student.surnameStudent} ${list_student.nameStudent} ${list_student.patronymicStudent}</a><br/>--%>
<%--</c:forEach>--%>
<%--</form>--%>
<%--</p>--%>


</body>
</html>
