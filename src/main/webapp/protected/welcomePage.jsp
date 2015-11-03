<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid">
    <div class="jumbotron">
        <p class="lead">Na sua opnião, entre as duas opções abaixo, qual é o melhor <b>Steakhouse</b>?</p>
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
                    <p align="center"><a ng-click="vote(restaurant);" href="#" class="btn btn-primary btn-block">Votar</a>
                    </p>
                </div>
            </div>
        </div> 
    </ul>
</div>

<script src="<c:url value="/resources/js/pages/welcomePage.js" />"></script>