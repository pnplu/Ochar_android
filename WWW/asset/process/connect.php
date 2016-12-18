<?php

$host = "127.0.0.1";
$user = "root";
$pass = "";
$db_name = "ochar";

$connect = mysqli_connect($host, $user, $pass, $db_name) or die("Error Connected");
mysqli_set_charset($connect, "utf8");

 ?>
