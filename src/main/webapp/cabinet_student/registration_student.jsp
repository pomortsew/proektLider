<%--
  Created by IntelliJ IDEA.
  User: pomortsew
  Date: 12.06.18
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация.</title>
</head>
<body>

<form action="/registration_student" method="post">

    <table align="center" width="500" height="500" bgcolor="aqua">
        <tr>
            <td align="center">
                <p>${errorRegistration}<br/></p>
                введите логин:<br/> <input type="text" title="Придумайте логин" value="${loginStudent}" name="login_student"
                                                           pattern="^([0-9A-Za-z\_\-\.]{1,})*$"><br/>
                введите пароль:<br/><input type="password" title="Пароль может содержать цифры, буквы Латинского алфавита верхнего и нежнего реристра и знаки ._#$%^&" value="${passwordStudent}" name="password_student"
                                           pattern="^([\.\_\!\#\$\%\^\&\*\+0-9A-Za-z]{1,})*$"><br/>
                введите Email: <br/><input type="text" title="Введите действующий Email" value="${mail}" name="email_student"
                                           pattern="^[a-zA-Z0-9]{1,}((\.|\_|-{0,1})[a-zA-Z0-9]{1,})*@[a-zA-Z0-9]{1,}((\.|\_|-{0,1})[a-zA-Z0-9]{1,})*\.[a-zA-Z]{2,}$"><br/>
                введите идентификационный номер <input type="text" title="Введите полученый идентификационный номер" value="${identificationNumber} "
                                                       name="identification_number"
                                                       pattern="^([a-zA-ZА-Яа-я0-9]{1,})*/([a-zA-ZА-Яа-я0-9]{1,})*-([a-zA-ZА-Яа-я0-9]{1,})$"><br/>
                <input type="submit" name="registration" value="Зарегистрироваться."><br/>
            </td>
        </tr>
    </table>
</form>

</body>
</html>
