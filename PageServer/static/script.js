var mainApp = angular.module('mainApp', []);

var fakeJson = {
  "songs": [
    {
      "Name": "Alfreds Futterkiste",
      "Artist": "Berlin",
      "Album": "Germany",
      "Art": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/First_abstract_watercolor_kandinsky_1910.jpg/300px-First_abstract_watercolor_kandinsky_1910.jpg",
      "Vote": 5,
    },
    {
      "Name": "Com\u00e9rcio Mineiro",
      "Artist": "S\u00e3o Paulo",
      "Album": "Brazil",
      "Art" : "https://s-media-cache-ak0.pinimg.com/736x/4b/8e/d1/4b8ed1d0e27433cefc37d344a3bdba02.jpg",
      "Vote": 3,
    },
    {
      "Name": "Com\u00e9rcio Mineiro",
      "Artist": "S\u00e3o Paulo",
      "Album": "Brazil",
      "Art" : "https://s-media-cache-ak0.pinimg.com/736x/4b/8e/d1/4b8ed1d0e27433cefc37d344a3bdba02.jpg",
      "Vote": 25,
    },
    {
      "Name": "Com\u00e9rcio Mineiro",
      "Artist": "S\u00e3o Paulo",
      "Album": "Brazil",
      "Art" : "https://s-media-cache-ak0.pinimg.com/736x/4b/8e/d1/4b8ed1d0e27433cefc37d344a3bdba02.jpg",
      "Vote": 123,
    },
    {
      "Name": "Com\u00e9rcio Mineiro",
      "Artist": "S\u00e3o Paulo",
      "Album": "Brazil",
      "Art" : "https://s-media-cache-ak0.pinimg.com/736x/4b/8e/d1/4b8ed1d0e27433cefc37d344a3bdba02.jpg",
      "Vote": 40,
    }
  ]
}

mainApp.controller('appController', ['$scope', '$http' , function ($scope, $http) {

$scope.curSong = {
	"Name": "My song",
	"Artist": "Raul",
	"Album": "Album",
	"Art": "http://www.abstractartistgallery.org/wp-content/uploads/2013/03/Abstract-Art-Painting-Tadeusz-Machowski-1.jpg"	
}
	// $http.get("http://www.w3schools.com/angular/customers.php").then(function(response){
	// 	$scope.networkList = response.data.records;
	// });

	$scope.list1 = fakeJson.songs;
}]);

mainApp.config(function($interpolateProvider) {
        $interpolateProvider.startSymbol('{a').endSymbol('a}');
    });