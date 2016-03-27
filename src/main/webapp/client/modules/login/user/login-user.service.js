(function () {

    angular.module('app').factory('loginService', ['$q', '$http', loginService]);

    function loginService($q, $http) {
        return {
            userLogin: userLogin,
        }
        
        function userLogin(data)
        {
           return $http({method: 'POST',data: data,url: HOST + USER_LOGIN}).then(function(response){return response.data;})
        }
    }
}());