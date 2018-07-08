<%--
  Created by IntelliJ IDEA.
  User: pomortsew
  Date: 07.06.18
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%--страница выбора действий для студента--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title> АНПОО БИЗНЕС-КОЛЛЕДЖ «ЛИДЕР»</title>
</head>
<body>
<h1 align="center"> Востановление пароля </h1>


<%--<form action="/registration_student" method="post" id="reg_stud"></form>--%>
<form action="" method="post" id="rec_pass_student">
    <table align="center" width="300" bgcolor="aqua">

        <tr>
            <td align="center">
                Введите Email который указывали при регистрации.
                На него придет письмо с паролем.
          <input type="email" title="Введите Email указаный при регистрации " name="mail" form="rec_pass_student">
                <input type="submit" title="Нажмите отправить для отпраки пароля на Ваш Email." name="submit" value="Отправить">
            </td>


        </tr>

    </table>
</form>

</table>
<%--<td align="center">--%>
<%--</td>--%>

</body>
</html>
