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
<h1 align="center"> Дистанционное обучение </h1>


<%--<form action="/registration_student" method="post" id="reg_stud"></form>--%>
<form action="/in_student" method="post" id="form_in_student">
    <table align="center" width="300" bgcolor="aqua">

        <tr>
            <td align="center">
              <p style="color: red">  ${error}<br/><p/>

                логин<br/>
                <input type="text" name="login_student" form="form_in_student"><br/>
                пароль<br/>
                <input type="password" name="password_student" form="form_in_student"><br/>
                <input type="submit" name="submit" value="Войти" form="form_in_student"><br/>
                <%--<input type="submit"  value="Регистрация" form= "reg_stud">--%>
  <a href="/cabinet_student/recover_password_student.jsp"   >Востановить пароль</a> </br>

            </td>


</tr>
    </table>
</form>
<table align="center" width="300" bgcolor="aqua">

    <tr>
        <td align="center">
<button  onclick="location.href='/cabinet_student/registration_student.jsp'">Регистрация</button><br/>
        </td>


    </tr>

</table>
<%--<td align="center">--%>
<%--</td>--%>

</body>
</html>
