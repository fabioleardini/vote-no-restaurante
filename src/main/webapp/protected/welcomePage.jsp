<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="row-fluid" ng-controller="welcomeController">
    <div class="jumbotron">
        <p class="lead">Na sua opnião, qual dos dois restaurantes é o melhor?</p>
    </div>
</div>
<div class="container">
    <div class="row">
        <ul class="thumbnails">
            <div class="col-md-4">
                <div class="thumbnail">
                    <img src="../resources/img/restaurants/outback.jpg" alt="..." class="img-responsive" />
                    <div class="caption">
                         <h3>Outback</h3>
                        <p>O Outback Steakhouse é um restaurante informal, construído e decorado em estilo que remete ao interior da Austrália. O cardápio inclui porções bem generosas, sendo oito variedades de steaks, opções de peixe, camarão, frango, carne suína, cordeiro, massas, sanduíches, sopas e saladas. Há também uma seleção de pratos especiais para crianças até 12 anos. Além disso, nossos aperitivos e sobremesas "comunitários" são realmente um grande diferencial em sabor e valor agregado.</p>
                        <p align="center"><a href="#" class="btn btn-primary btn-block">Votar</a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="thumbnail">
                    <img src="../resources/img/restaurants/applebees.jpg" alt="..." class="img-responsive" />
                    <div class="caption">
                         <h3>Applebee's</h3>
                        <p>A ideia era criar um restaurante que oferecesse os melhores serviços para seus clientes: boa comida, preço moderado e ótimo atendimento. Hoje, o conceito internacional da rede é o “neighborhood grill”, que traduz a preocupação em transmitir ao cliente um ambiente confortável e aconchegante</p>
                        <p align="center"><a href="#" class="btn btn-primary btn-block">Votar</a>
                        </p>
                    </div>
                </div>
            </div>            
        </ul>
    </div>
</div>

<script src="<c:url value="/resources/js/pages/welcome.js" />"></script>