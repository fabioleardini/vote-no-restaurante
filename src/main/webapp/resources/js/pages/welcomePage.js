function welcomeController($scope, $http, $window) {
    $scope.url = "/vote-no-restaurante/protected/";
	
	$scope.options = [{ id: 0, name: '0 (Não sei avaliar)' }, { id: 1, name: '1' }, 
	{ id: 2, name: '2' }, { id: 3, name: '3' }, { id: 4, name: '4' }, { id: 5, name: '5' }];
	
	$scope.grade = $scope.options[0];
	
    $scope.getRestaurantList = function () {
        var url = $scope.url + "restaurant";
        
        $http.get(url)
            .success(function (data) {
                $scope.restaurants = data;
            });
    }
	
	$scope.computeVote = function () {
		this.restaurant.userGrade = this.grade.id;
	}
	
	$scope.dismissAlert = function () {
		$('#emailError').addClass('hidden');
	}

    $scope.vote = function (restaurants) {
		$('#emailError').addClass('hidden');
			
        var url = $scope.url + "restaurant";
		var config = {params: {inputName: $('#inputName').val(), inputEmail: $('#inputEmail').val()}};

        $http.put(url, restaurants, config)
            .success(function (data) {
				if(data == "success"){
					$window.location.href = $scope.url 
					+ "vote?email=" + config.params.inputEmail
					+ "&name=" + config.params.inputName;
				}
				else if(data == "userexists"){
					$('#emailError').removeClass('hidden');
				}
            });
    }

    $scope.getRestaurantList();
}
