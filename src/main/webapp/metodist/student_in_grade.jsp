<%--список студентов в группе --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Студенты группы </title>
</head>
<body>
<c:forEach var="list_student_grades" items="${list_student_grade}">
    <table>
        <tr><tb>Фамилия</tb> <tb>Имя</tb><tb>Отчество</tb><tb>Идентификационный номер</tb><tb>Класс</tb> </br> </tr>
    <form id=${list_student_grades.identificationNumberStudent} name="forma1" action="/Info_student" method="post">
        <input type="hidden" name='student' value=${list_student_grades.identificationNumberStudent}>
    </form>
   <tr> <tb><a href="#"
       onclick="document.getElementById('${list_student_grades.identificationNumberStudent}').submit(); return false;">${list_student_grades.surnameStudent}</a> </br>
       </tb>
       <tb>${list_student_grades.nameStudent} </tb>
       <tb>${list_student_grades.patronymicStudent} </tb>
       </tr>
    </table>

</c:forEach>
</body>
</html>
