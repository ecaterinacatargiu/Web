<%@ page import="Model.UserProfile" %>
<%@ page import="Operations.GetUserByNameServlet" %>
<%@ page import="Operations.UserManager" %><%--
  Created by IntelliJ IDEA.
  User: Cati
  Date: 5/18/2020
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GetByName</title>
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
    <script type="text/javascript" charset="utf8" src="jquery-2.0.3.js"></script>
    <script>
        resp = "";
        function getAll()
        {
            $.ajax({
                type: 'GET',
                url: 'GetUserByNameServlet?text='+document.getElementById("name").value,
                dataType: 'json',
                success: function (data) {
                    $.each(data, function(index, element) {
                        $(document.getElementById("all")).append($("<tr><td>Name</td><td>Email</td><td>Picture</td><td>Age</td><td>Hometown</td>"))
                            .append("<tr><td>"+element.name+"</td><td>"+element.email+"</td><td><img width=100px height=50px src='data:image/bmp;base64,"+element.picture+"'/></td><td>"+element.age+"</td><td>"+element.hometown+"</td>");
                    });
                }
            });
            document.getElementById("all").innerHTML=resp;
        }

    </script>
    <script>getAll()</script>
</head>
<body>
    <h1>HERE</h1>
    <form>
        <table>
            <tr>
                <td> Enter string.. <input id = "name" name = "text" type="text"><br></td>
            </tr>
            <tr>
                <td> <input id="button" type="button" value="Filter" onclick="getAll()">  </td>
            </tr>
        </table>


        <div id="all">
            <table id="table" border="1">

            </table>
        </div>
    </form>




</body>
</html>
