var twitterReader = angular.module('twitterReader', []);

twitterReader.controller('TwitterReaderController', function ($scope, $http, $timeout) {
	var urlBase="http://localhost:8080/";

	$scope.tweets = [];

    // function to get salesforce tweets
	$scope.getSalesforceTweets = function() {
        $http.get(urlBase + '/fetchTweets')
            .then(function(results) {
                $scope.tweets = results.data;
                console.log(JSON.stringify($scope.tweets));
            });
    };

    // Function to replicate setInterval using $timeout service.
    $scope.intervalFunction = function(){
        $scope.getSalesforceTweets();

        $scope.firstTime = true;
        $timeout(function() {
            if (!$scope.firstTime) {
                $scope.getSalesforceTweets();
            }
            else {
                $scope.firstTime = false;
            }
            $scope.intervalFunction();
        }, 60000)
    };

    // Kick off the interval
    $scope.intervalFunction();
});