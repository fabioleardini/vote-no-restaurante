function rankingController($scope, $http, $window) {
	$scope.url = "/vote-no-restaurante/protected/";
	$scope.useremail;
	
	$scope.getGeneralRankingList = function(){
        var url = $scope.url + "restaurant/all";

        $http.get(url)
            .success(function (data) {
                $scope.allrestaurants = data;
				$scope.getUserRankingList();
            });
    }
	
	$scope.getUserRankingList = function(){
		var url = $scope.url + "ranking" + location.search;
		
		$http.get(url)
		.success(function (data) {
			$scope.rankings = data;
			$scope.useremail = data[0].useremail;
		});
	}

	$scope.getGeneralRankingList();
}