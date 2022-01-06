<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="client" class="entity.ClientEntity" scope="session" />
<jsp:useBean id="panier" class="pojo.Panier" scope="session" />

Total panier: <%= panier.getTotal() %> €

<form action="validation" method="post">
    <div class="form-group col-md-6 mx-auto mb-3">
        <label for="inputAddress">Adresse de livraison</label>
        <input type="text" class="form-control" id="inputAddress" name="inputAddress" value="${client.adresse}">
    </div>
    <button type="submit" class="btn btn-primary d-block mx-auto mb-3" name="validCommand">Valider la commande</button>
</form>