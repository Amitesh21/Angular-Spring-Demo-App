/*
 * IIFE to avoid polution of the global namespace.
 */
(function(){
    /*
     * Creating List controller and attaching it to the main turtleFacts module
     */
    angular
        .module("app")
        .controller("userCtrl", UserController);
    
        function UserController($scope, $http){
            $scope.name="amitesh";
            $scope.getUserResult = "";
            $scope.getUser = function(){
            
            $http({
              method: 'GET',
              url: 'http://localhost:8080/users'
            }).then(function successCallback(response) {
                console.log(response);    
                $scope.getUserResult = response;
              }, function errorCallback(response) {
                    console.log("error: "+response);
              });
        }
        

        $scope.submit = function(){
            var req = {
                 method: 'POST',
                 url: 'http://localhost:8080/register',
                 contentType:"application/json;charset=utf-8",
                 data: JSON.stringify({
                        "email" : $scope.email,
                         "name" : $scope.uname,
                         "password" : $scope.pwd  
                    })
                }
            
            $http(req).success(function(response) {
                    console.log("success");
                }).error(function(error) {
                    console.log("error");
                });
        }
    }

})();
