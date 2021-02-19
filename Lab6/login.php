<?php

    $serverName = "localhost";
    $userNameDB = "root";
    $passwordDB = "";
    $db = "logreports";

    $connection = mysqli_connect($serverName, $userNameDB, $passwordDB, $db);

    if(!$connection)
    {
        die("Connection failed!".mysqli_connect_error());
    }

    $user = $_GET["user"];
    $password = $_GET["password"];
    $query = "SELECT * FROM `user` WHERE `name`='$user' and `password`='$password'";
    $result = mysqli_query($connection, $query);

    if(mysqli_num_rows($result)==0)
    {
        echo "false";
    }
    else
    {
        $row = mysqli_fetch_array($result);
        echo "User found";
    }

    mysqli_close($connection);
?>