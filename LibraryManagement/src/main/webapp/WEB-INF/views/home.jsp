<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management</title>
<!--  	<link rel="stylesheet" href="style.css">  -->
	<script type="text/javascript" src="/WEB-INF/views/script.js"></script>
	<style type="text/css">
		body {
	background: #04A1BF;
	text-align: center;
	font-family: 'Open Sans', sans-serif;
}

.intro {
	margin: 30px 0px;
	font-weight: bold;
}

h1 {
	color: #ffffff;
	text-transform: uppercase;
	font-weight: 800;
}

p {
	font-weight: 600;
}

#first {
	margin-top: 10px;
	color: #FFCD5D;
}

#second {
	color: #51DF70;

}

#third {
	color: #800080;
	margin-bottom: 30px;
}


#enter {
	border: none;
	padding: 5px 15px;
	border-radius: 5px;
	color: #04A1BF;
	background-color: #025F70;
	transition: all 0.75s ease;
	-webkit-transition: all 0.75s ease;
	-moz-transition: all 0.75s ease;
	-ms-transition: all 0.75s ease;
	-o-transition: all 0.75 ease;
	font-weight: normal;
}

#enter:hover{
	background-color: #02798F;
	color: #FFCD5D;
}

ul {
	text-align: left;
	margin-top: 20px;
}


li {
	list-style: none;
	padding: 10px 20px;
	color: #ffffff;
	text-transform: capitalize;
	font-weight: 600;
	border: 2px solid #025f70;
	border-radius: 5px;
	margin-bottom: 10px;
	background: #4EB9CD;
	transition: all 0.75s ease;
	-webkit-transition: all 0.5s ease;
	-moz-transition: all 0.5s ease;
	-ms-transition: all 0.5s ease;
	-o-transition: all 0.5 ease;
}

li:hover {
	background: #76CFE0;
}

li > button {
	font-weight: normal;
	background: none;
	border: none;
	float: right;
	color: #025f70;
	font-weight: 800;
}

input {
	border-radius: 5px;
	min-width: 65%;
	padding: 5px;
	border: none;
}


.done {
	background: #51DF70 !important;
	color: #00891E;
}

.delete {
	display: none;
}
		
	</style>
	
	
	
	
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="intro col-12">
				<h1>Library Books List</h1>
				<div>
					<div class="border1"></div>
					
				</div>
			</div>
		</div>

		<div class="row">
			<div class="helpText col-12">
				<p id="first" style="font-size:25px;">Enter book name into the input field to add book to your list.</p>
			<!--  	<p id="second">Click the book tab to mark it as complete.</p>
				<p id="third">Click the "X" to remove the book from your list.</p>-->
			</div>
		</div>

		<form action="book" method="post"> 
		<div class="row">
			<div class="col-12">
				<input  type="text" placeholder="Add New book..." name="title" maxlength="100" required>
				<!--  <button id="enter"><i class="fas fa-pencil-alt"></i></button> -->
				<button type="submit">Add</button>
				
			</div>
		</div>
		</form>
		
		<div class="row">
			<div class="col-12">
				<p style="color:yellow;font-size:25px;">List of all books in library.</p>
				<form action="show" method="post">
					<button type="submit" style="width:250px;">Show all books </button>
					<p> 
					
					</p>
					<p> 
					
					</p>
				</form>
			</div>
			</div>	
			<div class="row">
			<div class="col-12">
				<c:forEach items="${titles}" var="title" > 
				
				
				<ul>
			<!-- <form action="delete" method="post"> varStatus="status" ${titles[status.index]}-->	
					<li>${title} </li>
				<!--	<input type="button" class="button" value="${book}" name="title">delete</input>	
				</form>	-->
				
				</ul>
				
				</c:forEach>
				
				</div>
			</div>	
				<form action="delete" method="post">
					<div class="row">
						<div class="col-12">
						<p style="color:yellow;font-size:25px;">Delete the unwanted books.</p>
						<!--  	<input type="text" placeholder="enter only above book id to delete ..." name="id" required> -->
							<div style="padding-down:1em;" > </div>
							<p> 
					
					</p>
							<input  type="text" placeholder="enter only above book name to delete..." name="title" maxlength="100" required>
							<button type="submit">Delete</button>
						</div>
					</div>
				</form>
			<!-- 	<form action="showing" method="get">
					<button type="submit">Show all books </button>
					<c:forEach items="${list}" var="book">  
				 
				<ul>
					<li>${book}</li>
				</ul>
				</c:forEach>
				</form>
			<!-- 	<c:if test="${not empty books}">
				<ul>
  					<li>Coffee</li>
  					<c:forEach var="title" items="${books}">
                		<li>${title}</li>
            		</c:forEach>
  					
				</ul>  
				</c:if>
				 -->
			<!-- 	<c:forEach items="${lists}" var="book">  
				 
				<ul>
					<li>${book.value}</li>
				</ul>
				</c:forEach>
			</div>
		</div>
		<c:forEach items="${lists}" var="book">  
				 
				<ul>
					<li>${book}</li>
				</ul>
				</c:forEach>  -->  
		<!-- Empty List -->
		<div class="row">
			<div class="listItems col-12">
				<ul class="col-12 offset-0 col-sm-8 offset-sm-2">
				</ul>
			</div>
		</div>
		</div>
	</div>
	<form action="logout" method="post">
		<button type="submit" style="width:150px;" >logout</button>
	</form>
	<script type="text/javascript" src="/WEB-INF/views/script.js"></script>
	
</body>
</html>