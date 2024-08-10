<%@page import="dao.Login_daoImpl"%>
<%@page import="pojo.message_Pojo"%>
<%@page import="java.util.List"%>
<%@page import="dao.message_daoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
</head>
<body class="bg-dark">

<% String user = (String) session.getAttribute("user");
String name = (String) session.getAttribute("name");
int id = 0;
try{
id =(Integer) session.getAttribute("id");
}catch(Exception e){
	e.printStackTrace();
}
message_daoImpl mimpl = new message_daoImpl();
List<message_Pojo> li = mimpl.getMessage();
Login_daoImpl limpl = new Login_daoImpl();
String sname = limpl.getUsernamebyId(id);
%>


<div class="container-fluid">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card mt-5">
<div class="card-header"><b>General Room</b>
<% if(user==null){ %>
<a href="login.jsp"><button class="btn btn-success float-right" type="button">Login</button></a><br>
<span>You are not Login Yet!!! <a href="login.jsp"> Login here!!!</a></span>
<%}else{ %>
<a href="logout"><button class="btn btn-danger float-right" type="button">Logout</button></a>
<br>
<span>Welcome, <%=name %></span>
<%} %>

</div>
<div class="card-body">
<form action="message_servlet" method="post">
<div class="input-group">
<input type="text" name="message" placeholder="Enter Your Message" class="form-control" autofocus>
<input type="hidden" name="sid" value="<%=id %>">
<input type="hidden" name="name" value="<%=sname %>">
<% if(user!=null){ %>
<div class="input-group-append">
<button class="btn btn-dark" type="submit">Send</button>
</div>
<%}else{ %>
<div class="input-group-append">
<a class="btn btn-dark disabled" aria-disabled="true">Send</a>
</div>
<%} %>
</div>
</form>
<div class="table-responsive">

<% for(message_Pojo m: li){ %>
<div class="mt-2"><%=m.getName()%>: <%=m.getMessage() %></div>
<%} %>

</div>
</div>
</div>
</div>
</div>
</div>

</body>
</html>