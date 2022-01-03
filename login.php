<html>
  <head>
    <title>Louis F Rossi - Home</title>
    <!-- CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

    </style>
    <!-- JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrapx-clickover.js"></script>
    <script>
    	$(document).ready(function(){
    		$(".alert").alert();
			$('#links').clickover({ auto_close: 100000 }); 
    	});
    </script>
  </head>
  <body>
     <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>
          <a class="brand" href="index.php">&#8592; Back to Site</a>
          <div class="nav-collapse collapse">
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>
      
    <div class="container">
      
      <form class="form-signin">
        <h2 class="form-signin-heading">Sign In</h2>
        <input type="text" class="input-block-level" placeholder="Username">
        <input type="password" class="input-block-level" placeholder="Password">
        <label class="checkbox">
          <input type="checkbox" value="remember-me"> Remember me
        </label>
        <button class="btn btn-large btn-primary" type="submit">Sign in</button>
      </form>
    </div> <!-- /container -->  
    
   </body>
      
      
</html>