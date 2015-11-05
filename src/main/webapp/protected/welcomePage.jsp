<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="masthead">
    <h2 class="muted">
        <spring:message code="header.welcome"/>
    </h2>
    <p class="text-info">
        <spring:message code="header.description"/>
    </p>
    <hr style="border-color:white">
</div>
<div class="row-fluid">
    <div class="jumbotron">
        <p class="lead"><spring:message code="welcome.message"/></p>
    </div>
</div>
<div class="row-fluid" ng-controller="welcomeController">    
	<div ng-repeat="restaurant in restaurants" class="col-md-6">
		<div class="thumbnail">
			<input type="hidden" />
			<img ng-src="{{ restaurant.img }}" alt="..." class="img-responsive" />
			<div class="caption">
				<h3>{{ restaurant.name }}</h3>
				<p>{{ restaurant.description }}</p>
				<p hidden>{{ restaurant.userGrade }}</p>
				<div class="form-group">
					<select class="form-control" ng-model="grade" ng-change="computeVote();" ng-options="option as option.name for option in options"></select>
				</div>
			</div>
		</div>
	</div>
	<form class="form-inline" name="welcomeForm" novalidate>
		<div class="form-group">
			<div class="form-group">
			  <div class="col-md-4">
				<input type="text" class="form-control" id="inputName" ng-model="inputName" placeholder="Nome" maxlength="100" ng-required="true">
			  </div>
			</div>
			<div class="form-group">
			  <div class="col-md-4">
				<input type="email" class="form-control" id="inputEmail" ng-model="inputEmail" placeholder="Email" maxlength="100" ng-required="true">				
			  </div>
			</div>
			<button type="submit" class="btn btn-primary" ng-click="vote(restaurants)" ng-disabled="!welcomeForm.$valid">Confirmar</button>
		</div></br></br>
		<div class="alert alert-dismissible alert-danger hidden" id="emailError">
			<button type="button" class="close" ng-click="dismissAlert()">x</button>
			<strong><spring:message code="welcome.user"/></strong>
		</div>
	</form>	
</div>

<script src="<c:url value="/resources/js/pages/welcomePage.js" />"></script>