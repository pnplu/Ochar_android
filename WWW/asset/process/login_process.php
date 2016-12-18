<?php

require "./connect.php";

if (isset($_POST["button_login"]))
{
  $email = mysqli_real_escape_string($connect, $_POST["username"]);
  $password = mysqli_real_escape_string($connect, $_POST["password"]);

  $sel_user = "SELECT * FROM user WHERE user_email = '$email' AND user_password = '$password'";
  $run_user = mysqli_query($connect, $sel_user);
  $check_user = mysqli_num_rows($run_user);

  if ($check_user > 0)
  {
    $_SESSION["username_show"] = "Admin";
    header("location: ../../dashboard.php");
  }
  else
  {
    echo "<script>alert('Email or password is not correct, try again!')</script>";
  }
}

 ?>
