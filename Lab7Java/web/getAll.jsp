<%--
  Created by IntelliJ IDEA.
  User: Cati
  Date: 5/16/2020
  Time: 11:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View All</title>
    <script src="jquery-2.0.3.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        function getAll()
        {
            xhrGet = new XMLHttpRequest();
            xhrGet.open("GET", "/GetAllServlet", true);
            xhrGet.send();
            let resp="";
            xhrGet.onreadystatechange=function()
            {
                let json;
                if (this.readyState===4 && this.status===200)
                {
                    console.log(this.responseText)
                    json = JSON.parse(this.responseText);
                    for(let i = 0; i < json.length; i++)
                    {
                        const obj = json[i];
                        console.log("HERE")
                        console.log(obj)
                        console.log(obj[1])
                        console.log("STOP")
                    }
                    document.getElementById("all").innerHTML=resp;
                }
            }
        }
    </script>


</head>
<body>

    <h1> All User Profiles Registered : </h1>

    <script>getAll()</script>
    <div id="all"></div>



</body>
</html>
