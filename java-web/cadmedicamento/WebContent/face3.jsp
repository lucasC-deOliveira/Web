<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
		window.fbAsyncInit = function() {
			FB.init({
				appId : '384862779252834',
				cookie : true,
				xfbml : true,
				version : 'v10.0'
			});

			FB.AppEvents.logPageView();

		};

		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id)) {
				return;
			}
			js = d.createElement(s);
			js.id = id;
			js.src = "https://connect.facebook.net/en_US/sdk.js";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));

		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});

		function checkLoginState() {
			  FB.getLoginStatus(function(response) {
			    statusChangeCallback(response);
			  });
			}
		function statusChangeCallback(response) {  // Called with the results from FB.getLoginStatus().
		    
		    console.log(JSON.stringify(response));               // The current login status of the person.
		    if (response.status === 'connected') {   // Logged into your webpage and Facebook.
		      testAPI(response.userID);  
		    } else {                                 // Not logged into your webpage or we are unable to tell.
		      document.getElementById('status').innerHTML = 'Please log ' +
		        'into this webpage.';
		    }
		  }

		function testAPI() {                      
		    console.log('Welcome!  Fetching your information.... ');
		    FB.api('/me', {fields: 'name, email'}, function(response){
		      //console.log('Successful login for: ' + response.name);
		       console.log(JSON.stringify(response));  
		     
		    });
		  }

		  
		  
	</script>

	<fb:login-button scope="public_profile,email"
		onlogin="checkLoginState();">
	</fb:login-button>


</body>
</html>