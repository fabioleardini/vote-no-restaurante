function voteController($scope, $http, $window) {
	$scope.url = "/protected/";
	
	$scope.options = [{ id: 0, name: '0 (Não sei avaliar)' }, { id: 1, name: '1' }, 
	{ id: 2, name: '2' }, { id: 3, name: '3' }, { id: 4, name: '4' }, { id: 5, name: '5' }];

	$scope.grade = $scope.options[0];
	
	$scope.getChurrascariaList = function(){
        var url = $scope.url + "restaurant/vote" + location.search;

        $http.get(url)
            .success(function (data) {
                $scope.restaurants = data.restaurantList;
				$('#userEmail').val(data.userEmail);
				$('#userName').val(data.userName);
            });
    }
	
	$scope.vote = function (restaurants) {
		$('#emailError').addClass('hidden');
		
		var url = $scope.url + "restaurant/vote";
		var config = {params: {inputName: $('#inputName').val(), inputEmail: $('#inputEmail').val()}};
		var userEmail = $('#userEmail').val();
		var userName = $('#userName').val();
		
		if(config.params.inputEmail == userEmail && config.params.inputName == userName){
		
			$http.put(url, restaurants, config)
			.success(function (data) {
				if(data == "success"){
					$window.location.href = $scope.url + "ranking?userEmail=" + userEmail;
				}
			});
		}
		else{
			$('#emailError').removeClass('hidden');
		}
	}
	
	$scope.computeVote = function () {
		this.restaurant.userGrade = this.grade.id;
	}

    $scope.open = function () {
        $scope.confirmVoteModal = true;
    }
	
	$scope.dismissAlert = function () {
		$('#emailError').addClass('hidden');
	}

	$scope.getChurrascariaList();
}