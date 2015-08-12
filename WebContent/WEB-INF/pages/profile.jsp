<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href= "/insta/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/insta/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<script type="text/javascript" src="/insta/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/insta/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/insta/resources/js/canvasjs.min.js"></script>
<script src="/insta/resources/angular/angular.min.js"></script>
<script src="/insta/resources/scripts/insta.js"></script>
 <style type="text/css">
   #googlemaps { 
      height: 100%; 
      width: 100%; 
      position:absolute; 
      top: 0; 
      left: 0; 
      z-index: 0; /* Set z-index to 0 as it will be on a layer below the contact form */
    }
     
    #contactform { 
      position: relative; 
      z-index: 1; /* The z-index should be higher than Google Maps */
      width: 300px;
      margin: 60px auto 0;
      padding: 10px;
      background: black;
      height: auto;
      opacity: .45; /* Set the opacity for a slightly transparent Google Form */ 
      color: white;
    }
    </style> 
    
    <script src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
 
<script type="text/javascript">
 
// The latitude and longitude of your business / place
var position = [27.1959739, 78.02423269999997];
 
function showGoogleMaps() {
 
    var latLng = new google.maps.LatLng(position[0], position[1]);
 
    var mapOptions = {
        zoom: 16, // initialize zoom level - the max value is 21
        streetViewControl: false, // hide the yellow Street View pegman
        scaleControl: true, // allow users to zoom the Google Map
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        center: latLng
    };
 
    map = new google.maps.Map(document.getElementById('googlemaps'),
        mapOptions);
 
    // Show the default red marker at the location
    marker = new google.maps.Marker({
        position: latLng,
        map: map,
        draggable: false,
        animation: google.maps.Animation.DROP
    });
}
 
google.maps.event.addDomListener(window, 'load', showGoogleMaps);
</script>
<style type="text/css">
ul#main_menu {
    list-style:none;
}
ul#main_menu li {
display:inline-block;
}
ul#main_menu li a{
display: inline-block;
background-color: #fefefe;
border: 1px solid;
list-style: none;
padding: 3px;
border-radius: 5px 5px;
color:rgb(40,40,40);
    text-decoration:none;
}
ul#main_menu li a:hover {
    background-color: rgb(150,150,150);
}
</style>
    
</head>
<body>
<nav>
     <ul id='main_menu'> 
        <li><a href='/'>Home</a></li>
        <li><a href='/l1'>Link1</a></li>
        <li><a href='/l2'>Link2</a></li>
        <li><a href='/l3'>Link3</a></li>
    </ul>
</nav>

    <div id="googlemaps"></div>
    <div id="contactform">
      <h1>Please enter your zipcode</h1>
    </div>
</body>
</html>