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
<div ng-controller="voteController">
    <div class="row-fluid">
        <div class="jumbotron">
            <p class="lead"><spring:message code="churrascaria.message"/></p>
        </div>
    </div>
    <div class="row-fluid">
		<div ng-repeat="restaurant in restaurants" class="col-md-4">
			<div class="thumbnail">
				<input type="hidden" />
				<img ng-src="{{ restaurant.img }}" alt="..." class="img-responsive" />
				<div class="caption">
					<h3>{{ restaurant.name }}</h3>
					<p>{{ restaurant.description }}</p>
					<div class="form-group">
						<select class="form-control" ng-model="grade" ng-change="computeVote();" ng-options="option as option.name for option in options"></select>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-12">
			<button type="button" class="btn btn-primary center-block" data-toggle="modal" data-target="#confirmVoteModal">Avaliar</button>
		</div>
    </div>
    <div id="confirmVoteModal" class="modal" role="dialog">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
            <h4 class="modal-title"><spring:message code="vote.modal.title"/></h4>
          </div>
          <div class="modal-body">
            <form class="form-horizontal">
              <fieldset>
                <legend><spring:message code="vote.modal.legend"/></legend>
                <div class="form-group">
                  <label for="inputName" class="col-lg-2 control-label">Nome</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" id="inputName" placeholder="Nome">
                  </div>
                </div>
                <div class="form-group">
                  <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                  <div class="col-lg-10">
                    <input type="text" class="form-control" id="inputEmail" placeholder="Email">
                  </div>
                </div>                
              </fieldset>
            </form>
          </div>
          <div class="modal-footer">
            <button type="reset" class="btn btn-default" data-dismiss="modal">Cancelar</button>
            <button type="submit" class="btn btn-primary" ng-click="vote(restaurants);">Confirmar</button>
          </div>
		  <div class="alert alert-dismissible alert-danger hidden" id="emailError">
			<button type="button" class="close" ng-click="dismissAlert()">x</button>
			<strong><spring:message code="vote.user"/></strong>
		  </div>
		  <input type="hidden" id="userEmail"/>
		  <input type="hidden" id="userName"/>
        </div>
      </div>
    </div>  
</div>

<script src="<c:url value="/resources/js/pages/vote.js" />"></script>