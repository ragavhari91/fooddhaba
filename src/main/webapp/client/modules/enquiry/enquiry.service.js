(function () {

    angular.module('app').factory('enquiryService', ['$q', '$http', enquiryService]);

    function enquiryService($q, $http) {
        return {
            getEnquiryPreloadData: getEnquiryPreloadData,
            createBusinessEnquiry : createBusinessEnquiry
        }
        
        function getEnquiryPreloadData()
        {
           return $http({method: 'GET',url: HOST + ENQUIRY_PRELOAD}).then(function(response){return response.data;})
        }
        
        function createBusinessEnquiry(data)
        {
            return $http({method: 'POST',data: data,url: HOST + ENQUIRY_SUBMIT}).then(function(response){return response.data;})
        }
    }
}());