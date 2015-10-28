angular.module("PhoneBook", []).controller('ContactsController', ['$scope', '$http', function ($scope, $http) {


 
    $scope.searchType = {
        type: 'all',
        searchbox: false
    };
    $scope.searchTypeAll = {
        type: 'all',
        searchbox: false
    };
    $scope.searchTypePrefix = {
        type: 'prefix',
        searchbox: true,
        searchPattern : /^[0-9]{2,45}$/,
        errorText : "Prefix should contains only digits"
    };
    $scope.searchTypeSurname = {
        type: 'surname',
        searchbox: true,
        searchPattern : /^[A-Z][a-z]{1,44}$/,
        errorText : "Last name should contains only letters. First letter should be capital."
    };

    $scope.contacts = [];

    $http.get('/phoneBook/restful-services/phoneBookService/json/allRecords').success(function (data) {
        $scope.contacts = data;
    });

    $scope.getAll = function () {
        $http.get('/phoneBook/restful-services/phoneBookService/json/allRecords').success(function (data) {
            $scope.contacts = data;
        });
    };



    $scope.message = 'nada';
    $scope.searchClick = function (searchedPhrase) {
        if ($scope.searchType.type == 'prefix') {
            $http.get('/phoneBook/restful-services/phoneBookService/json/byPrefixRecord/' + searchedPhrase).success(function (data) {
                $scope.contacts = data;
                $scope.message = searchedPhrase;
            });

        };
        if ($scope.searchType.type == 'surname') {
            $http.get('/phoneBook/restful-services/phoneBookService/json/byNameRecord/' + searchedPhrase).success(function (data) {
                $scope.contacts = data;
            });
            $scope.message = searchedPhrase;
        };
    };


}]);
