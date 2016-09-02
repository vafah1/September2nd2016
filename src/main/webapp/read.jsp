<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top center">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../index.html">Shoe Club</a>
    </div>
    <div>
      <ul class="nav navbar-nav">
        <li><a href="index.html">Home</a></li>
        <li><a href="shoecloset.html">Shoe Closet</a></li>
        <li class="active"><a href="myshoecloset.html">My Shoe Closet</a></li> 
        <li><a href="myshoecart.html">My Shoe Cart</a></li> 
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="pages/signup.html"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
         <li id="login-link">
        <div class="dropdown">
        <button class="btn dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-log-in"></span>  Login
       </button>
        <ul class="dropdown-menu">
        <li id="login">
          <form>
             <div class="form-group">
                  <label for="email">Email address:</label>
                  <input type="email" class="form-control" id="email">
             </div>
             <div class="form-group">
                  <label for="pwd">Password:</label>
                  <input type="password" class="form-control" id="pwd">
             </div>
             <div class="checkbox">
                  <label><input type="checkbox"> Remember me</label>
             </div>
                  <button type="submit" class="btn btn-default">Submit</button>
          </form>
          </li>
          </ul>
          </div>
       </li>
      </ul>
    </div>
  </div>
</nav>
<div class="panel panel-primary">
  	  <div class="panel-heading">Welcome To Shoe Club!</div>
  	  <div class="panel-body" style="text-align: center;">
  	  	<form action="addToDB" method="post" class="form-inline">
        <div class="container">
          <h2>Add a shoe to your closet:</h2>
          </div>
              <div class="form-group">
                  <label for="manufacturer">Manufacturer</label>
                  <input name="manufacturer" type="manufacturer" class="form-control" id="manufacturer">
             </div>
             <div class="form-group">
                  <label for="shoetype">Shoe Type</label>
                  <input name="shoe_type" type="shoetype" class="form-control" id="shoetype">
             </div>
             <div class="form-group">
                  <label for="size">Shoe Size</label>
                  <input name="shoe_size" type="size" class="form-control" id="size">
             </div>
             <div class="form-group">
                  <label for="price">Price</label>
                  <input name="shoe_price" type="price" class="form-control" id="price">
             </div>
                  <button name="add" type="add" class="btn btn-default">Add Shoe</button>   
          </form>
          <div class="container">
          <h2>Update an existing shoe in your closet:</h2>
          </div>
          <form class="form-inline">
         <div class="form-group">
                  <label for="Itemid">Item ID #</label>
                  <input name="shoe_id" type="itemid" class="form-control" id="itemid">
             </div>
             <div class="form-group">
                  <label for="manufacturer">Manufacturer</label>
                  <input name="manufacturer" type="manufacturer" class="form-control" id="manufacturer">
             </div>
             <div class="form-group">
                  <label for="shoetype">Shoe Type</label>
                  <input name="shoe_type" type="shoetype" class="form-control" id="shoetype">
             </div>
             <div class="form-group">
                  <label for="size">Shoe Size</label>
                  <input name="shoe_size" type="size" class="form-control" id="size">
             </div>
             <div class="form-group">
                  <label for="price">Price</label>
                  <input name="shoe_price" type="price" class="form-control" id="price">
             </div>
                  <button name="update" type="update" class="btn btn-default">Update Shoe</button>   
          </form>
          <div class="container">
          <h2>Delete a shoe from your closet:</h2>
          </div>
          <form class="form-inline">
         <div class="form-group">
                  <label for="Itemid">Item ID #</label>
                  <input name="shoe_id" type="itemid" class="form-control" id="itemid">
             </div>            
                  <button name="delete" type="delete" class="btn btn-default">Delete Shoe</button>   
          </form>
  	  </div>
	 </div>
</body>
</html>