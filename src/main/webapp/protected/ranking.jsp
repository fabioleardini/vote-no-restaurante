<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="masthead">
    <h2 class="muted">
        <spring:message code="ranking.header.welcome"/>
    </h2>
    <p class="text-info">
        <spring:message code="ranking.header.description"/>
    </p>
    <hr style="border-color:white">
</div>
<div ng-controller="rankingController">
	<div class="row-fluid">
		<h2><spring:message code="ranking.general"/></h2>
	    <ul class="list-group">
		  <li class="list-group-item" ng-repeat="restaurant in allrestaurants">
		    <span class="badge">{{ restaurant.totalGrade }}</span>
				{{ restaurant.name }}
		  </li>
		</ul>
	</div>
	<div class="row-fluid">
		<h2><spring:message code="ranking.user"/> {{ ranking.userEmail }}</h2>
	    <ul class="list-group">
		  <li class="list-group-item" ng-repeat="ranking in rankings">
		    <span class="badge">{{ ranking.grade }}</span>
				{{ ranking.restaurantname }}
		  </li>
		</ul>
	</div>
	<div class="form-group">
		<a type="submit" class="btn btn-primary center-block" href="../protected/home"><spring:message code="ranking.back.home"/></a>
	</div>
</div>

<script src="<c:url value="/resources/js/pages/ranking.js" />"></script>