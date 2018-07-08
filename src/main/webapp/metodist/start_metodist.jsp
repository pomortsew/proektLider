<%--
  Created by IntelliJ IDEA.
  User: pomortsew
  Date: 07.06.18
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%--страница выбора действий для методиста--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Упарвление </title>
</head>
<body>
<h1> Выберете нужное действие </h1>
Зачислить студента: <button onclick="location.href='/metodist/enlistement.jsp'">Зачислить студента</button><br/>

Отчислить студента: <button onclick="location.href='/metodist/select_deduct.jsp'">Отчислить студента</button><br/>

<form action="/Search_info_student" method="post">
Информация о студенте:  <button  onclick="location.href='/metodist/search_info_student.jsp'">Информация о студенте</button><br/>

</form>
Установить оповещение <form action="${pageContext.request.contextPath}/Setting_message" method="post">
    <input type="submit" name="button1" value="Button 1" />
    <input type="submit" name="button2" value="Button 2" />
    <input type="submit" name="button3" value="Button 3" />
</form>
</body>
</html>
