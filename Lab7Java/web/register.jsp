<%--
  Created by IntelliJ IDEA.
  User: Cati
  Date: 5/9/2020
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
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
    <form action="/UploadServlet" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td> Enter your name: </td> <td> <input type="text", name="name"><br> </td>
            </tr>

            <tr>
                <td>Enter your email:</td> <td>  <input type="text", name="email"><br> </td>
            </tr>

            <tr>
                Upload your picture: </td> <td> <input type="file", name="picture", value="Upload picture">

            </tr>

            <tr>
                <td>Enter your age:  </td> <td> <input type="text", name="age"><br> </td>
            </tr>

            <tr>
                <td> Enter your hometown:  </td> <td> <input type="text", name="hometown"><br> </td>
            </tr>

            <tr>
                <td> Enter your password: </td> <td> <input type="password", name="password"><br> </td>
            </tr>

            <tr>
                <td> <input type="submit" value="Register"> </td> <td>  <a href="login.jsp">Already have an account?</a> </td>
            </tr>
        </table>
    </form>


    </div>

</body>
</html>
