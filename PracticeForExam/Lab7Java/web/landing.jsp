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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script>
        $(document).ready(function(){
            $("#all").click(function(){
                $.get("/CoursesCtrl",function(data){
                    $("#courses").html(data)
                })
            })
            $("#gets").click(function(){
                $.get("/StudentCtrl",{name:document.getElementById("student").value},function(data){
                    $("#courses").html(data)
                })
            })
        })

        function grade(id)
        {
            console.log(id);
            $.post("/CoursesCtrl", {id: id, name: document.getElementById("name").value, grade: document.getElementById("grade").value}, function(data){
                document.getElementById("assign").innerHTML = "";
                $.get("/CoursesCtrl",function(data){
                    $("#courses").html(data)
                })
            })
        }

        function cursclick(id)
        {
            console.log(id);
            document.getElementById("assign").innerHTML="Student name: <input type=\"text\" id=\"name\"> <br> Grade: <input type=\"text\" id=\"grade\">" +
                "<button type=\"button\" id=\"grd\" onclick=grade(" + id+ ")>Grade</button>" ;
        }

    </script>

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

            <button type="button" id="all">See all my courses</button>

            <br>
            Student: <input type="text" id="student">
            <button type="button" id="gets">Get Student</button>
            <div id="courses">
            </div>
            <div id="assign">

            </div>
        </form>



</body>
</html>
