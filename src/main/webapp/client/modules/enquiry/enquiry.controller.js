(function(){

     angular.module('app').controller('enquiryController', ['$scope', '$location','$state','enquiryService',enquiryController]);
    
    function enquiryController($scope,$location,$state,enquiryService){
        
        $scope.preloaddatas = [];
        $scope.enquiry      = {};
        
        $scope.getEnquiryPreloadData = function()
        {
            enquiryService.getEnquiryPreloadData().then(function(response){
                
                
                $scope.preloaddatas = response;
                
            });
        }
        
        $scope.submitEnquiry = function()
        {
            $scope.enquiry = {
               "name":$scope.name,
               "email_id":$scope.email_id,
               "mobile_no":$scope.mobile_no,
               "business_type_id":$scope.business_type.id,
                "business_name":$scope.business_name,
                "business_address":$scope.business_address,
                "enquiry_status":1,
                "comments":$scope.comments
            };
            console.log("Enquiry"+JSON.stringify($scope.enquiry));
            enquiryService.createBusinessEnquiry($scope.enquiry).then(function(response){
                 console.log("Enquiry Form"+JSON.stringify(response));
            });
        }
    }

}());