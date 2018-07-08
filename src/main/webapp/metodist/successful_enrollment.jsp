<%--
  Created by IntelliJ IDEA.
  User: pomortsew
  Date: 05.06.18
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%--страница успешного зачисления студента и выбора действий--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Успешное зачисление.</title>
    <link rel="stylesheet" href="../w3.css">
</head>


<body class="w3-blue-gray">
${sts}

Студент:                          "${surname} ${name} ${patronymic}"<br/>
зачислен на обучение в класс:     "${grade}"<br/>
по професси:                      "${profession}"<br/>
за номером:                       "${identification}"<br/>
<form action="/Select_student_deduct" method="post">

    <button onclick="location.href='metodist/select_student_deduct.jsp'">отчислить студента </button><br/>

</form><br/>
    <button onclick="location.href='/enlistement.jsp'">зачислить еще</button><br/>

</body>
</html>
