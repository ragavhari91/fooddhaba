(function () {

    angular.module('app').factory('salesService', ['$q', '$http', salesService]);

    function salesService($q, $http) {
        return {
            getInitialData: getInitialData,
        }
        
        function getInitialData(data)
        {
           return $http({method: 'POST',data: data,url: HOST + SALES_INITIAL}).then(function(response){return response.data;})
        }
    }
}());