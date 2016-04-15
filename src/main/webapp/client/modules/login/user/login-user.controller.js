(function () {

    angular.module('app').controller('loginController', ['$scope', '$location','$state','loginService',loginController]);
    
    function loginController($scope,$location,$state,loginService){
    	
    	
        $scope.loginSubmit = function(){
        	
        	console.log("HELLO");
            var data = {
                "email_address":$scope.emailID,
                "password":$scope.password
            };
            
            loginService.userLogin(data).then(function(response){
                
            	console.log("RESPONSE"+JSON.stringify(response));
                if(response.status === "Failure")
                {
                    $scope.status_message = response.message;
                }
                else
                {
                    $scope.status_message = response.message; 
                    localStorage.setItem("fd_init",JSON.stringify(response));
                    $state.go("profile");
                }
               
            });
        }
    }
}());


