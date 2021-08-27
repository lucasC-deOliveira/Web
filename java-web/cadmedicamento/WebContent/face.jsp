<!DOCTYPE html>
<html>
<head>
<title>Facebook Login JavaScript Example</title>
<meta charset="UTF-8">
</head>
<body>
<script>
   function loginFace(){
	   FB.login(function(response) {
		   console.log(JSON.stringify(response));  
		 }, {scope: 'public_profile,email'});

	}
	

  function statusChangeCallback(response) {  
    console.log('statusChangeCallback');
    console.log(response);                   
    if (response.status === 'connected') {   
      testAPI();  
    } else {                                 
    	// implementar algo
    }
  }


  function checkLoginState() {               
    FB.getLoginStatus(function(response) {   
      statusChangeCallback(response);
    });
  }


  window.fbAsyncInit = function() {
    FB.init({
      appId      : '384862779252834',
      cookie     : true,                     
      xfbml      : true,                     
      version    : 'v10.0'           
    });


    FB.getLoginStatus(function(response) {   
      statusChangeCallback(response);        
    });
  };
 
  function testAPI() {                      
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', {fields: 'name, email'}, function(response){
      //console.log('Successful login for: ' + response.name);
       console.log(JSON.stringify(response));  
     
    });
  }

</script>


<!-- The JS SDK Login Button -->

<!--  <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button> -->


<script async defer crossorigin="anonymous" src="https://connect.facebook.net/pt_BR/sdk.js#xfbml=1&version=v10.0&appId=384862779252834&autoLogAppEvents=1" nonce="GlIbILK8"></script>
<div onlogin="checkLoginState();" class="fb-login-button" data-width="" data-size="large" data-button-type="continue_with" data-layout="default" data-auto-logout-link="false" data-use-continue-as="false"></div>



</body>
</html>