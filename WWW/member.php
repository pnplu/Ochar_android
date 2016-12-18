<?php
session_start();
require "./asset/process/connect.php";
$sql = "SELECT * FROM account";
$sql_query = mysqli_query($connect, $sql);
 ?>

 <!DOCTYPE html>
 <html>
   <head>
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <title>Dashboard</title>
     <link rel="stylesheet" href="./bootstrap/css/bootstrap.css">
     <link rel="stylesheet" href="./bootstrap/css/bootstrap-theme.css">
     <link rel="stylesheet" href="./asset/stylesheet/css/style_dashboard.css">
     <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/prettify/r224/prettify.min.css">
     <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
     <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.2/raphael-min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
     <script src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r224/prettify.min.js"></script>
     <script src="./bootstrap/js/bootstrap.js"></script>
     <script src="./bootstrap/js/npm.js"></script>
     <script src="./asset/js/morris.js"></script>
   </head>
   <body>
     <div class="container-fluid">
       <div class="row">
         <div class="col-sm-3 set_pos_col2">
             <div class="image_box"></div>
             <div class="box_set_ad">
               <p>Admin</p>
               <p><a href="./asset/process/logout.php">Logout</a></p>
             </div>
         </div> <!-- col-sm-2 -->
         <div class="col-sm-9">
           <ul class="nav nav-tabs set_nav">
              <li><a href="dashboard.php">Food</a></li>
              <li><a href="ingredient.php">Ingredient</a></li>
              <li class="active"><a href="#">Member</a></li>
           </ul>
           <div class="col-sm-12 set_bg_sm12_food">
             <!-- <div id="area-example" class="set_pos_graph"></div> -->
             <div class="col-sm-6">

             </div> <!-- col-sm-6 -->
             <div class="col-sm-6">

             </div> <!-- col-sm-6 -->
             <div id="graph"></div>
             <table class="table table-striped set_tb">
               <thead style="background-color: #FFFFFF;">
                 <tr>
                   <th>No</th>
                   <th>Name</th>
                   <th>Display Name</th>
                   <th>email</th>
                 </tr>
               </thead>
               <tbody style="background-color: #FFFFFF;">
                 <?php
                 while ($rows = mysqli_fetch_assoc($sql_query))
                 {
                   $id = $rows["user_id"];
                   $usernames = $rows["username"];
                   $dp_user = $rows["display_name"];
                   $email = $rows["email"];
                  ?>
                 <tr>
                   <td><?= $id ?></td>
                   <td><?= $usernames ?></td>
                   <td><?= $dp_user ?></td>
                   <td><?= $email ?></td>
                 </tr>
                 <?php
                }
                  ?>
               </tbody>
             </table>
           </div>
         </div> <!-- col-sm-10 -->
       </div>
     </div>
     <script type="text/javascript">
     Morris.Donut({
       element: 'graph',
       data: [
         {value: 70, label: 'foo'},
         {value: 15, label: 'bar'},
         {value: 10, label: 'baz'},
         {value: 5, label: 'A really really long label'}
       ],
       formatter: function (x) { return x + "%"}
     }).on('click', function(i, row){
       console.log(i, row);
     });
     </script>
   </body>
 </html>
