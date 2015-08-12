<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Page</title>
<link href= "/insta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/insta/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<script type="text/javascript" src="/insta/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/insta/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/insta/resources/js/canvasjs.min.js"></script>
<script src="/insta/resources/angular/angular.min.js"></script>
<script src="/insta/resources/scripts/insta.js"></script>
<script type="text/javascript" src="https://raw.githubusercontent.com/enyo/dropzone/master/dist/dropzone.js"></script>
<link rel="stylesheet" href="https://rawgit.com/enyo/dropzone/master/dist/dropzone.css">
</head>
<body>

<div id="navigation">
        <nav class="navbar navbar-fixed-top" role="navigation">
			<div class="container">
				<div class="row">
				    <div class="col-md-2">
						<div class="site-logo">
							<a href="index.html" class="hasdropdown active" ">Insta</a>
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
								  <li><a href="/insta/signin">Signin</a></li>
								   <li><a href="/insta/signup">Signup</a></li>
								   </security:authorize>
								    <security:authorize access="!isAnonymous()">
          <security:authorize access="hasAnyRole('ROLE_USER')">
								  <li><a href="/insta/upload">Upload</a></li>				                                                                  								  
								  <li><a href="/insta/images">Images</a></li>
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


<div class="col-md-8" style="top: 100px">
      <form action="/insta/file/multifileupload"
      class="dropzone"
      id="my-awesome-dropzone">
      <div class="dz-message upload-photos-height">
    Drop Photos here or click to upload.<br />
  </div>
<input type="hidden"  value="${imageId}" name ="imageId">      
      </form>
      
      </div>

</body>
</html>