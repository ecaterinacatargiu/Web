<%--
  Created by IntelliJ IDEA.
  User: Cati
  Date: 5/9/2020
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>

        body {
            background: #b7a0bd;
        }

        form{
            border: purple 1px;
            width: 20%;
            border-radius: 6px;
            margin: 150px auto;
            background: rosybrown;
            padding: 50px;
        }

        input{
            width: 100%;
        }

        button{
            color: black;
            background: whitesmoke;
            padding: 10px;
            margin-left: 110px;
        }





    </style>
</head>
<body>
    <form action="LoginServlet" method="post">
        <table>

            <tr>
                <td> Enter username: </td> <td> <input type="text" name="name" placeholder="username"><br> </td>
            </tr>
            <tr>
                <td>Enter password: </td> <td> <input type="password" name="password" placeholder="password"><br></td>
            </tr>
            <tr>
                <td> <input type="submit" value="Login"> </td> <td> <a href="register.jsp">Not registered yet?</a></td>
            </tr>
        </table>

    </form>






</body>
</html>
