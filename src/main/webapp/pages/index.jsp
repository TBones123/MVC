<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Radus
  Date: 14.05.2018
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<h1>hello world</h1>
<form action="/person" method="post">
    <input type="text" name="name" >
    <input type="number" name="age">
    <input type="submit" name="">
</form>
        <div>
            <c:forEach var="human" items="${people}">
                <p>${human.name}</p>
                <p>${human.age}</p>
                <hr>

            </c:forEach>


        </div>




</body>
</html>
