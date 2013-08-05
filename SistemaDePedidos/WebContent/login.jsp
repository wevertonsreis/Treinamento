<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html:html>
	<head>
		<title>Login</title>
		<link rel="stylesheet" type="text/css" href="style.css">
	</head>
	<body>
	<div id="loginForm">
		<h1>Sistema de Pedidos</h1>
	
		<div id="erroForm"> 
			<html:errors/>
		</div>
	
		<html:form action="/login">
			
				<div class="field">
					 <bean:message key="label.username"/> 
					 <html:text property="username" name="loginForm"/>
				</div>
				<div class="field">
					 <bean:message key="label.password"/> 
					 <html:password property="password" name="loginForm"/>
				</div>
					
				<html:submit  styleId="submitForm" value=" Entrar "/> 
				
		</html:form>
		</div>
	</body>
</html:html>