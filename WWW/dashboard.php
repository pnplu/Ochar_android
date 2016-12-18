<?php
session_start();
require "./asset/process/connect.php";
$sql = "SELECT * FROM menu_food";
$sql_query = mysqli_query($connect, $sql);
// echo "Admin";
// echo "<a href='./asset/process/logout.php'>logout</a>";
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
     <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.css">
     <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
     <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
     <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
              <li class="active"><a href="#">Food</a></li>
              <li><a href="ingredient.php">Ingredient</a></li>
              <li><a href="member.php">Member</a></li>
           </ul>
           <div class="col-sm-12 set_bg_sm12_food">
             <div id="area-example" class="set_pos_graph"></div>
             <div class="col-sm-6">

             </div> <!-- col-sm-6 -->
             <div class="col-sm-6">

             </div> <!-- col-sm-6 -->
             <table class="table table-striped set_tb">
               <thead style="background-color: #FFFFFF;">
                 <tr>
                   <th>No</th>
                   <th>Menu</th>
                   <th>Food_cooking_method</th>
                 </tr>
               </thead>
               <tbody style="background-color: #FFFFFF;">
                 <?php
                  while ($rows = mysqli_fetch_assoc($sql_query))
                  {
                    $id = $rows["food_id"];
                    $food_name = $rows["food_name"];
                    $food_cooking = $rows["food_cooking_method"];
                  ?>
                 <tr>
                   <td><?= $id ?></td>
                   <td><?= $food_name ?></td>
                   <td><?= $food_cooking ?></td>
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
     var neg_data = [
   {"period": "2011-08-12", "a": 100},
   {"period": "2011-03-03", "a": 75},
   {"period": "2010-08-08", "a": 50},
   {"period": "2010-05-10", "a": 25},
   {"period": "2010-03-14", "a": 0},
   {"period": "2010-01-10", "a": -25},
   {"period": "2009-12-10", "a": -50},
   {"period": "2009-10-07", "a": -75}
 ];
 Morris.Line({
   element: 'area-example',
   data: neg_data,
   xkey: 'period',
   ykeys: ['a'],
   labels: ['Series A'],
   units: '%'
 });
     </script>
   </body>
 </html>
