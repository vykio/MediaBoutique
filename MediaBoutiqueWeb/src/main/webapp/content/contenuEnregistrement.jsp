<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3 class="card-title text-center">Création de votre compte</h3>

<form action="register" method="post">
    <div class="row mb-3">
        <div class="form-group col-md-6" >
            <label for="inputName">Nom</label>
            <input type="text" class="form-control" id="inputName" name="inputName" placeholder="Nom">
        </div>
        <div class="form-group col-md-6">
            <label for="inputEmail">Email</label>
            <input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="Email">
        </div>
    </div>
    <div class="row mb-3">
        <div class="form-group col-md-6">
            <label for="inputPassword">Mot de passe</label>
            <input type="password" class="form-control" id="inputPassword" name="inputPassword" placeholder="Mot de passe">
        </div>
        <div class="form-group col-md-6">
            <label for="inputPassword-verify">Réecrivez votre mot de passe</label>
            <input type="password" class="form-control" id="inputPassword-verify" name="inputPassword-verify" placeholder="Mot de passe">
        </div>
    </div>
    <div class="form-group mb-3">
        <label for="inputAddress">Adresse</label>
        <input type="text" class="form-control" id="inputAddress" name="inputAddress" placeholder="1234 Main St">
    </div>
    <div class="form-group col-md-6 mx-auto mb-3" >
        <label for="inputPhone">Telephone</label>
        <input type="tel" class="form-control" id="inputPhone" name="inputPhone" pattern="[0-9]{10}" placeholder="0123456789">
        <small id="inputPhoneHelpBlock" class="form-text text-muted">
            Le numéro de téléphone doit contenir exactement 10 chiffres.
        </small>
    </div>

    <button type="submit" class="btn btn-primary d-block mx-auto mb-3" name="createAccount">Créer mon compte</button>
    <a href="login">
        <p class="text-center">Vous avez déjà un compte ?</p>
    </a>
</form>