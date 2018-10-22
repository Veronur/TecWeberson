<!DOCTYPE html>
 <head> 
<meta charset="UTF-8">
</head>
<body>
<center>

<h1>Bem Vindo!</h1>
<div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'pt', includedLanguages: 'en,pt'}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
       
<h2>Login com Facebook</h2> 
<script>
 // This is called with the results from from FB.getLoginStatus().
 function statusChangeCallback(response) {
 console.log('statusChangeCallback');
 console.log(response);
 // The response object is returned with a status field that lets the
 // app know the current login status of the person.
 // Full docs on the response object can be found in the documentation
 // for FB.getLoginStatus().
 if (response.status === 'connected') {
 // Logged into your app and Facebook.
 testAPI();
 } else if (response.status === 'not_authorized') {
 // The person is logged into Facebook, but not your app.
 document.getElementById('status').innerHTML = 'Login with Facebook ';
 } else {
 // The person is not logged into Facebook, so we're not sure if
 // they are logged into this app or not.
 document.getElementById('status').innerHTML = 'Login with Facebook ';
 }
 }
 // This function is called when someone finishes with the Login
 // Button. See the onlogin handler attached to it in the sample
 // code below.
 function checkLoginState() {
 FB.getLoginStatus(function(response) {
 statusChangeCallback(response);
 });
 }
 window.fbAsyncInit = function() {
 FB.init({ 
 appId : '326958941191427',
 cookie : true, // enable cookies to allow the server to access 
 // the session
 xfbml : true, // parse social plugins on this page
 version : 'v2.2' // use version 2.2
 });
 // Now that we've initialized the JavaScript SDK, we call 
 // FB.getLoginStatus(). This function gets the state of the
 // person visiting this page and can return one of three states to
 // the callback you provide. They can be:
 //
 // 1. Logged into your app ('connected')
 // 2. Logged into Facebook, but not your app ('not_authorized')
 // 3. Not logged into Facebook and can't tell if they are logged into
 // your app or not.
 //
 // These three cases are handled in the callback function.

 FB.getLoginStatus(function(response) {
 statusChangeCallback(response);
 });
 };
 // Load the SDK asynchronously
 (function(d, s, id) {
 var js, fjs = d.getElementsByTagName(s)[0];
 if (d.getElementById(id)) return;
 js = d.createElement(s); js.id = id;
 js.src = "//connect.facebook.net/en_US/sdk.js";
 fjs.parentNode.insertBefore(js, fjs);
 }(document, 'script', 'facebook-jssdk')); 

 // Here we run a very simple test of the Graph API after login is
 // successful. See statusChangeCallback() for when this call is made.
 function testAPI() { 
 console.log('Welcome! Fetching your information.... ');
 FB.api('/me?fields=name,email', function(response) {
 console.log('Successful login for: ' + response.name); 
 
 document.getElementById("status").innerHTML = '<p>Ola '+response.name+'!  <a href=FbLogin?user_name='+ response.name.replace(" ", "_") +'&user_email='+ response.email +' >Continuar com Login do Facebook</a></p>'
 });
 } 
</script> 



<!--
 Below we include the Login Button social plugin. This button uses
 the JavaScript SDK to present a graphical Login button that triggers
 the FB.login() function when clicked.
-->
<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">Entrar/Registrar
</fb:login-button>
<div id="status">
</div> 
 <script type="text/javascript">
</script>
</center>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<center>
<%@ page import="java.util.*,br.insper.tecweb.p2.model.*" %>
<h2>Login Manual</h2>
<%
	DAO dao = new DAO();
	List<Usuarios> pessoas = dao.getLista();
%>
	<form action="login" method="post">
		Login:<br>
  		<input type="text" name="Login"><br>
		Senha:<br>
  		<input type="text" name="senha"><br>
		<input type="submit" value="LOGIN">
	</form>
	<form action="NewUser" method="post">
	<input type="submit" value="Registrar"/> 
	</form>

</center>
</body>

</html>