<%--
  Created by IntelliJ IDEA.
  User: Cati
  Date: 5/16/2020
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Profile</title>
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



    <form action = "UpdateServlet" method="post", enctype="multipart/form-data">
        <p> ${name} , here you can update your profile..</p>
        <table>
            <tr>
                <td> Enter your email: </td> <td> <input type="text" name="email"><br> </td>
            </tr>

            <tr>
                <td>Upload your picture:</td> <td>  <input type="file" name="picture"><br> </td>
            </tr>

            <tr>
                <td> Enter your age: </td> <td> <input type="text" name="age"><br></td>
            </tr>

            <tr>
                <td>Enter your hometown:  </td> <td> <input type="text" name="hometown"><br> </td>
            </tr>

            <tr>
                <td> <input type="submit" value="Update"> </td>
            </tr>
        </table>

    </form>

</body>
</html>
