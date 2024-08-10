<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body class="bg-dark">
<div class="container mt-5" style="width:500px;">
	<form action="Register_servlet" method="post">
	<div class="card p-5" style="border-radius:10px;">
	<h2 class="text-center">Registration Form</h2>
	<div class="form-group">
    <label for="exampleInputName2">Name</label>
    <input type="text" class="form-control" name="name" id="exampleInputName2" aria-describedby="emailHelp" placeholder="Enter First Name">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Email-Id</label>
    <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Email-Id">
  </div>
  <div class="form-group">
    <label for="exampleInputName2">Phone Number</label>
    <input type="text" class="form-control" name="number" id="exampleInputName2" aria-describedby="emailHelp" placeholder="Enter Last Name">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password" id="exampleInputPassword1" placeholder="Enter Password">
  </div>
  <div class="text-center">
  <button type="submit" class="btn btn-primary" style="width: 150px;">Register</button>
  <p class="mt-2">Already have an account, <a href="login.jsp">Login here</a></p>
  </div>
  </div>
</form>
	</div>


</body>
</html>