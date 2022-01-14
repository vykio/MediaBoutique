<%@ page import="utils.Connection" %>
<%@ page import="entity.ClientEntity" %>
<%@ page import="static utils.Utils.requestAttributeExists" %>
<%@ page import="entity.CommandeClientEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getParameter("path");
    String title = request.getParameter("title");
%>

<html>
<head>
    <jsp:include page="common/header.jsp">
        <jsp:param name="title" value="<%= title %>"/>
    </jsp:include>
</head>
<body class="d-flex flex-column h-100">
    <nav class="navbar navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand me-auto" href="index">Media Bootique</a>
                <%
                    if (Connection.isLoggedIn(session)) {
                        String username = ((ClientEntity) session.getAttribute("client")).getNom();
                %>
                    <span ><%= username %></span>
                    <a class="nav-item nav-link" href="logout">Se déconnecter</a>
                <%
                    } else {
                %>
                    <a class="nav-item nav-link active" href="register">Inscription</a>
                    <a class="nav-item nav-link" href="login">Connexion</a>
                <%
                    }
                %>
            </ul>
        </div>
    </nav>

<main class="flex-shrink-0">
    <div class="container" style="padding-top: 50px">
        <% if (requestAttributeExists(request, "error-msg")) {
            String alertMsg = (String)request.getAttribute("error-msg");
        %>
        <div class="alert alert-danger" id="failure-alert">
            <strong>Erreur ! </strong> <%= alertMsg %>
        </div>
        <%
            }
        %>

        <% if (requestAttributeExists(request, "confirmation") && requestAttributeExists(request, "confirmation") ) {
            String alertMsg = (String)request.getAttribute("confirmation");
            CommandeClientEntity command = (CommandeClientEntity) request.getAttribute("command");
            alertMsg = alertMsg + " Le numéro de confirmation de votre commande est le n°" + command.getNoConfirmation();
            request.removeAttribute("command");
        %>

        <div class="alert alert-success" id="success-alert">
            <strong>Bravo ! </strong> <%= alertMsg %>
        </div>
        <%
            }
        %>


        <div class="alert alert-success" id="success-alert" style="display: none">
            <strong>Réussite! </strong> Le produit a été ajouté à votre panier
        </div>
        <div class="row align-items-start full-height">
            <div class="col-3 no-float">
                <div class="card">
                    <div class="card-body">
                        <jsp:include page="basic/menu.jsp" />
                    </div>
                </div>
            </div>
            <div class="col-9 no-float">
                <div class="card">
                    <div class="card-body">
                        <jsp:include page="<%= path %>" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
<jsp:include page="common/footer.jsp" />
</html>
