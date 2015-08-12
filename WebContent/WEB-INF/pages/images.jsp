<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Images</title>
<link href= "/insta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/insta/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<script type="text/javascript" src="/insta/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/insta/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/insta/resources/js/canvasjs.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="/insta/resources/angular/angular.min.js"></script>
<script src="/insta/resources/scripts/insta.js"></script>
</head>
<body ng-app="insta">
<div id="navigation">
        <nav class="navbar navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="row">
				    <div class="col-md-2">
						<div class="site-logo">
							<a href="index.html" class="brand">Insta</a>
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
								  <li class="active"><a href="/insta/">Home</a></li>
								   <security:authorize access="isAnonymous()">
								  <li><a href="/insta/signin">Signin</a></li>
								   <li><a href="/insta/signup">Signup</a></li>
								   </security:authorize>
								    <security:authorize access="!isAnonymous()">
          <security:authorize access="hasAnyRole('ROLE_USER')">
								  <li><a href="#works">Works</a></li>				                                                                  								  
								  <li><a href="#contact">Contact</a></li>
								  <li><a href="/insta/profile">Welcome..<security:authentication property="principal.username"/></a></li>
          <li><a href="/insta/logout">Logout</a></li>
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
<div class="jumbotron">
<h1>Images Page</h1>
</div>

	
  
 

 <div ng-controller="imagePageController">
<div class="container-fluid background-black" >
<div class="container">
 
 <div class="row">
<div class="col-md-12">
<h1>Images</h1>
                <div class="db-wrapper">
                    <div class="db-pricing-seven">
                        <ul>
                            <li class="price">
                                <i class="fa fa-camera fa-3x"></i>
                                {{image.imageName}}<br>
                                Size: {{image.imageSize}} Bytes<br>
                                Content Type: {{image.imageContentType}}<br>
                                uploaded by: {{image.imageUploadedBy}}<br>
                                uploaded on: {{image.createdDataString}}<br>
                                <h4 class="h4"><span class="label label-success">
            					 {{image.imagePrivateString}}
                				  </span>
                            </li>
                            <li>
                            
                            <h5 ng-repeat="data in metadata">{{data.key}} : {{data.value}}</h5>
                           
                            
                            </li>
                        </ul>
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                        </div>
                       
                        </body>
                        </html>
                      
