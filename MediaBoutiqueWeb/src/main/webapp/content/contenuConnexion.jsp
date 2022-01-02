<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3 class="card-title text-center">Connectez vous à votre compte</h3>

<form action="login" method="post">
  <div class="form-group col-md-6 mx-auto mb-3" >
    <label for="inputEmail-login">Email</label>
    <input type="email" class="form-control" id="inputEmail-login" name="inputEmail-login" placeholder="Email">
  </div>
  <div class="form-group col-md-6 mx-auto mb-3">
    <label for="inputPassword-login">Mot de passe</label>
    <input type="password" class="form-control" id="inputPassword-login" name="inputPassword-login" placeholder="Mot de passe">
  </div>
  <button type="submit" class="btn btn-primary d-block mx-auto mb-3" name="login">Se connecter</button>
  <a href="register">
    <p class="text-center">Vous n'avez pas de compte ?</p>
  </a>
</form>