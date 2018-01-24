'use strict';

angular.module('test')
    .controller('DetailCtrl', function ($scope, test, $routeParams, $location) {
        
    	$scope.load = function() {
            test.get($routeParams.id, function (response) {
                $scope.detail = response.data;
            });
        }
  		
        $scope.load();
  		
    	$scope.borrado = function() {
            test.borrado($routeParams.id, function() {
            	alert("Libro borrado satisfactoriamente.");
            	$location.url('/');
            });
        }
    });
