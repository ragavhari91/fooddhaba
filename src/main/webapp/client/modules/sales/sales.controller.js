(function () {
    
angular.module('app').controller('salesController',['$scope','$location','$state','salesService',salesController]);
    
    function salesController($scope,$location,$state,salesService)
    {
        salesService.getInitialData().then(function(response){
            console.log("RESP"+response); 
        });
    }



}());
    	
    	