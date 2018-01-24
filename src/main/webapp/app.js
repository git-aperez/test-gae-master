'use strict';
angular
    .module('test', ['ngRoute'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/list.html',
                controller: 'ListCtrl',
                controllerAs: 'list'
            })
            .when('/:id', {
                templateUrl: 'views/detail.html',
                controller: 'DetailCtrl',
                controllerAs: 'detail'
            })
            .when('/nombre/:nombre', {
                templateUrl: 'views/list.html',
                controller: 'ListCtrl',
                controllerAs: 'list'
            })
            .when('/autor/:autor', {
                templateUrl: 'views/list.html',
                controller: 'ListCtrl',
                controllerAs: 'list'
            })
            .otherwise({
                redirectTo: '/'
            });
    });
