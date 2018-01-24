'use strict';

angular.module('test')
    .controller('ListCtrl', function ($scope, test) {

        $scope.load = function() {
            test.list(function (list) {
                $scope.list = list.data;
            });
        }

        $scope.save = function() {
            test.save($scope.form, function() {
                $scope.load();
            });
        }
        
        $scope.form = {};

        $scope.load();
        
        $scope.filtro = 'autor';
        
    	$scope.search = function(filtro) {
//            test.search($scope.form.busqueda, function(response) {
//            	$scope.list = response.data;
//            	$location.url('/');
//            });

    		if (filtro === 'autor'){
                test.searchAutor($scope.form.busqueda, function(response) {
                	$scope.list = response.data;
//                	$location.url('/');
                });
    		}
            else {
                test.searchNombre($scope.form.busqueda, function(response) {
                	$scope.list = response.data;
//                	$location.url('/');
                });
    		}
        }
    });
