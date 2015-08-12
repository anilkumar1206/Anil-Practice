<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
<link href= "/insta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/insta/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<script type="text/javascript" src="/insta/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/insta/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/insta/resources/js/canvasjs.min.js"></script>

</head>

<body>

<div id="navigation">
        <nav class="navbar navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="row">
				    <div class="col-md-2">
						<div class="site-logo">
							<a href="index.html" class="hasdropdown active" >Insta </a>
						</div>
				    </div>					  

					<div class="col-md-10">	 
						<!-- Brand and toggle get grouped for better mobile display -->
						<div class="navbar-header">
							<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#menu">
								<i class="fa fa-bars"></i>
							</button>
						</div>
						<!-- Collect the nav links, forms, and other content for toggling -->
						<div class="collapse navbar-collapse" id="menu">
							<ul class="nav navbar-nav navbar-right">
								  <li class="active"><a href="#home">Home</a></li>
								   <security:authorize access="isAnonymous()">
								  <li><a href="/insta/signin"><span class="glyphicon glyphicon-log-in"></span> Signin</a></li>
								   <li><a href="/insta/signup"><span class="glyphicon glyphicon-user"></span> Signup</a></li>
								   </security:authorize>
								    <security:authorize access="!isAnonymous()">
          <security:authorize access="hasAnyRole('ROLE_USER')">
								  <li><a href="/insta/upload"><span class="glyphicon glyphicon-upload"></span> Upload</a></li>				                                                                  								  
								  <li><a href="/insta/images"><span class="glyphicon glyphicon-picture"></span> Images</a></li>
								  <li><a href="/insta/profile"><span class="glyphicon glyphicon-user"></span> Welcome..<security:authentication property="principal.username"/></a></li>
          <li><a href="/insta/logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
          </security:authorize>
          </security:authorize>
							</ul>
						</div>
						<!-- /.Navbar-collapse -->		 
					</div>
				</div>
			</div>
			<!-- /.container -->
		</nav>
    </div> 
    
    <div id="home">
		<div class="slider">
			<img src="/insta/resources/images/homeimage.jpg" class="img-responsive" />
		</div>
	</div>
    
   
	
    <footer>
		<div class="container">
			<div class="row">
				<div class="col-md-6 col-md-offset-3">					
					<div class="text-center">
						<a href="#home" class="scrollup"><i class="fa fa-angle-up fa-3x"></i></a>
						<p>ThankYou for visiting Insta<br />
						&copy;Copyright 2015 - Insta. </p>
					</div>
				</div>
			</div>	
		</div>
	</footer>

    


</body>

</html>
    
    


