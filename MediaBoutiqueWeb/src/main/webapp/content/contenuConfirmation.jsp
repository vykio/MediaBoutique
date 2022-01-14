<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="client" class="entity.ClientEntity" scope="session" />
<jsp:useBean id="panier" class="pojo.Panier" scope="session" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3>Informations client</h3>

<div class="row mb-3">
    <div class="form-group col-md-6" >
        <label for="recapName">Nom</label>
        <input type="text" class="form-control" id="recapName" name="recapName" value="${client.nom}" disabled readonly>
    </div>
    <div class="form-group col-md-6">
        <label for="recapEmail">Email</label>
        <input type="email" class="form-control" id="recapEmail" name="recapEmail" value="${client.email}" disabled readonly>
    </div>
</div>
<div class="form-group mb-3">
    <label for="recapAddress">Adresse</label>
    <input type="text" class="form-control" id="recapAddress" name="recapAddress" value="${client.adresse}" disabled readonly>
</div>
<div class="form-group col-md-6 mx-auto mb-3" >
    <label for="recapPhone">Telephone</label>
    <input type="tel" class="form-control" id="recapPhone" name="recapPhone" pattern="[0-9]{10}" value="${client.telephone}" disabled readonly>
</div>

<hr>

<table class="table" id="panier">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Article</th>
        <th scope="col">Prix</th>
        <th scope="col">Quantité</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${panier_items}" varStatus="status" >
        <tr>
            <th scope="row"></th>
            <td>${item.produit.nom}</td>
            <td>${item.produit.prix}€</td>
            <td>${item.quantity}</td>
        </tr>
    </c:forEach>
    <tr>
        <th scope="row" colspan="2">Total</th>
        <td><span id="panierTotal"><jsp:getProperty name="panier" property="total"/> €</span></td>
    </tr>
    </tbody>
</table>

<form action="validation" method="post">
    <div class="form-group col-md-6 mx-auto mb-3">
        <label for="inputAddress">Adresse de livraison</label>
        <input type="text" class="form-control" id="inputAddress" name="inputAddress" value="${client.adresse}">
    </div>
    <button type="submit" class="btn btn-primary d-block mx-auto mb-3" name="validCommand" onclick="commandValidation()">Valider la commande</button>
</form>