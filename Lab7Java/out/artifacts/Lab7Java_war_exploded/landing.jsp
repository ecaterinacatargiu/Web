<%--
  Created by IntelliJ IDEA.
  User: Cati
  Date: 5/9/2020
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Landing Page</title>

    <style>

        body {
            background: #b7a0bd;
        }

        a {
            background: tomato;
        }

        form{
            border: purple 1px;
            width: 20%;
            border-radius: 6px;
            margin: 150px auto;
            background: rosybrown;
            padding: 50px;
        }
    </style>
</head>
<body>
        <%
            if(session.getAttribute("name")==null)
            {
                response.sendRedirect("login.jsp");
            }

        %>

        <form>
            <p> This page is visible to logged in users only <p>
            <p>  Welcome dear ${name} </p>

            <a href="update.jsp"> My Profile.. </a> <br>

            <a href="filter.jsp"> Look for friends </a> <br>

            <a href="getAll.jsp"> View All </a> <br>

            <a href="getAllByName.jsp"> View All By Name </a>
        </form>



</body>
</html>
