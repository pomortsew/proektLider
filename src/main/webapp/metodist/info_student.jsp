
<%--страница показывает информацию о студенте --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Информация о студенте  </title>
</head>
<body>

<table>
    <tr>
    <td>Фамилия</td> <td>Имя</td><td>Отчество</td>
    </tr>
    <tr> <td> <a href="start_metodist.jsp">${surname}</a>,</td>
        <td> ${name},</br></td>
        <td> ${patronymic},</br></td>
    </tr>
 номер ${id_number},</br>
 класс ${grade_student},</br>
профессия ${profession_student},</br>
дата регистрации ${date_of_registration},</br>
контакты ${contact_student},</br>
курс ${cours_student},</br>

</table>

</body>
</html>