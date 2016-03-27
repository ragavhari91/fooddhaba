(function(){
    
    angular.module('app').controller('userController', ['$scope', '$location', 'userRegistrationService', '$state' , userController]);

    function userController($scope, $location, userRegistrationService, $state) 
    {
        $scope.status_message = "";
        
        $scope.registrationSubmit = function()
        {
            var data = {
                "first_name":$scope.first_name,
                "last_name":$scope.last_name,
                "email_address":$scope.email_id,
                "password":$scope.password
            };
            
            userRegistrationService.userRegistration(data).then(function(response){
            	console.log("USER REGISTRATION"+JSON.stringify(response));
                
                if(response.status === "Failure")
                {
                    $scope.status_message = response.message;
                }
                else
                {
                    $scope.status_message = response.message; 
                }
               
            });
            
        }
    }
    
}());