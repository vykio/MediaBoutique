<jsp:useBean id="categories" class="java.util.ArrayList" scope="session" />
<jsp:useBean id="produits" class="java.util.ArrayList" scope="session" />

<%@ page import="ejb.MaBootiqueEJB" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="entity.CategorieEntity" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="${pageContext.request.contextPath}/assets/js/addToCart.js"></script>

<div class="row">
    <div class="col-sm-3">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Catégories</h5>
                <nav class="navbar navbar-expand-lg navbar-light">
                    <div class="container-fluid">
                        <div class="collapse navbar-collapse" id="navbarNav">

                            <ul class="navbar-nav flex-column">

                                <c:forEach var="categorie" items="${categories}" >
                                    <li class="nav-item"> <a class="nav-link" href="categories?id=${categorie.id}"> ${categorie.nom} </a></li>
                                </c:forEach>

                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <div class="col-sm-9">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Sélectionnez une catégorie pour afficher les produits disponibles</h5>
                <hr/>

                    <c:forEach var="produit" items="${produits}" >

                        <div class="col-sm-12 mb-3">
                            <div class="card">
                                <div class="card-body">

                                        <h5>${produit.nom}</h5>
                                        ${produit.prix}€
                                        <button type="submit" class="btn btn-outline-primary" style="float: right" onclick="addToCart(${produit.id})">Ajouter au panier</button>

                                </div>
                            </div>
                        </div>
                    </c:forEach>

            </div>
        </div>
    </div>
</div>

