var myapp = angular.module('insta',[]);




myapp.controller('imagesController',function($scope,$http){
	$http.get("/insta/service/user/images").success(function(data){
		$scope.userImages = data;	
		$scope.test="message";
	});
});


myapp.controller('imagePageController',function($scope,$http,$window){
	$scope.imageId = $window.imageId;
	$http.get("/insta/service/user/images/"+$scope.imageId).success(function(data){
		$scope.image = data;	
	});
	
	
});



