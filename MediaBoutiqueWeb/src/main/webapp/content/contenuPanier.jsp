<jsp:useBean id="panier_items" class="java.util.ArrayList" scope="session" />
<jsp:useBean id="panier" class="pojo.Panier" scope="session" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/assets/js/removeFromCart.js"></script>


<table class="table" id="panier">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Article</th>
        <th scope="col">Prix</th>
        <th scope="col">Quantité</th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${panier_items}" varStatus="status" >
        <tr>
            <th scope="row"></th>
            <td>${item.produit.nom}</td>
            <td>${item.produit.prix}€</td>
            <td>${item.quantity}</td>
            <td>
                <button id="button-remove-${item.productId}" type="submit" class="btn btn-outline-danger float-right" onclick="removeFromCart(${item.productId})">Retirer du panier</button>
            </td>
        </tr>
    </c:forEach>
        <tr>
            <th scope="row" colspan="2">Total</th>
            <td><span id="panierTotal"><jsp:getProperty name="panier" property="total"/> €</span></td>
        </tr>
    </tbody>
</table>

<a id="validation-panier" class="btn btn-success btn-lg d-block mx-auto" href="register" role="button"> Valider le panier </a>
