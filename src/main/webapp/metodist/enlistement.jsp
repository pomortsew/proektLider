
<%--
  Created by IntelliJ IDEA.
  User: pomortsew
  Date: 07.06.18
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%--страница зачисления студента--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Зачисление студента</title>
</head>
<body>
<h1> Введите данные студента.</h1>
<form action="/Enlistement" method="post">
    ${error_input_name}<br/>
    Введите фамилию студента*: <input type="text" value="${surname}" ${surname} name="surname" pattern="^[А-Яа-я]*$"><br/>
    Введите имя студента*: <input type="text" value="${name}" ${name} name="name"pattern="^[А-Яа-я]*$"><br/>
    Введите отчество студента*: <input type="text" value="${patronymic}" ${patronymic} name="patronymic"pattern="^[А-Яа-я]*$"><br/>
    ${error_identification_number}<br/>
    Введите идентификационный номер студента в формате text/text-text: <input type="text" value="${identification-number}" name="identification-number" pattern="^([a-zA-ZА-Яа-я0-9]{1,})*/([a-zA-ZА-Яа-я0-9]{1,})*-([a-zA-ZА-Яа-я0-9]{1,})$"><br/>
    Введите группу студента в формате text-text-text: <input type="text" value="${grade}" ${grade} name="grade" pattern="^([a-zA-ZА-Яа-я0-9]{1,})*-([a-zA-ZА-Яа-я0-9]{1,})*-([a-zA-ZА-Яа-я0-9]{1,})$"><br/>
    Выберите профессию студента*
    <select name="profession"><br/>
        ${profession}
        <option value="Электрик" name="profession1 ">Электрик</option>
        <option value="Гончар" name="profession2">Гончар</option>
        <option value="Переворачиватель пингвинов" name="profession3">Переворачиватель пингвинов</option>
    </select>
    <p><input type="submit" name="enlistement" value="Зачислить" ><br></p>
</form>


</body>
</html>