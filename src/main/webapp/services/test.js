'use strict';

angular.module('test')
    .service('test', function ($http) {
        return {
            list: function (success) {
                return $http.get("/rest/test").then(success);
            },
            save: function (test, success) {
                return $http.post("/rest/test", test).then(success);
            },
            borrado: function (id, success) {
                return $http.delete("/rest/test" + '/' + id).then(success);
            },
            get: function (id, success) {
                return $http.get("/rest/test" + '/' + id).then(success);
            },
            search: function (autor, success) {
                return $http.get("/rest/test" + '/s/' + autor).then(success);
            },
            searchAutor: function (autor, success) {
                return $http.get("/rest/test" + '/autor/' + autor).then(success);
            },
            searchNombre: function (nombre, success) {
                return $http.get("/rest/test" + '/nombre/' + nombre).then(success);
            }            
        };
    });
