<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome Ochar</title>
    <link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="./bootstrap/css/bootstrap-theme.css">
    <link rel="stylesheet" href="./asset/stylesheet/css/style_home.css">
    <script src="./bootstrap/js/bootstrap.js"></script>
    <script src="./bootstrap/js/npm.js"></script>
  </head>
  <body>
    <div class="container-fluid">
      <div class="row">
        <!-- <div class="col-sm-4"></div> -->
        <div class="col-sm-4 col-sm-offset-5 bottom-align">
          <div class="col_centered">
            <form action="./asset/process/login_process.php" method="post">
              <p>Email</p>
              <input type="text" name="username"><br>
              <p>Password</p>
              <input type="password" name="password"><br><br>
              <button class="set_po_btn" type="submit" name="button_login">Sign in</button>
              <button type="reset">Cancel</button>
            </form>
          </div>
        </div>
        <!-- <div class="col-sm-4"></div> -->
      </div>
    </div>
  </body>
</html>
