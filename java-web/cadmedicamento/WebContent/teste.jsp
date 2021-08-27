<html lang="pt-br">
<head>
  <!DOCTYPE html>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Google authentication - Exemplo 2</title>
  <link rel="stylesheet" href="css/style.css">

  <!-- Fonte Roboto do Google -->
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/css/bootstrap-theme.min.css">
</head>
<body>
  <div class="container body-content">
    <div class="box-login">
      <h2>Login</h2>

      <!-- C�digo html do bot�o de login -->
      <div id="gSignInWrapper">
        <div id="customBtn" class="customGPlusSignIn">
          <span class="icon"></span>
          <span class="buttonText">Logar com o Google</span>
        </div>
      </div>
      <div id="name"></div>

      <hr/>
      <a href="javascript:void(0);" onclick="signOut();">Sign out</a>
    </div>

    <hr />
    <footer>
      <p>&copy; F�brica de C�digo</p>
    </footer>
  </div>

  <script src="js/example.js"></script>

  <!-- Google api -->
  <script src="https://apis.google.com/js/api:client.js"></script>

  <!--JQuery e Bootstrap - N�o s�o obrigat�rios para ao autentica��o -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.6/js/bootstrap.min.js"></script>

  <!-- fun��o para iniciar o app -->
  <script>startApp();</script>
</body>
</html>