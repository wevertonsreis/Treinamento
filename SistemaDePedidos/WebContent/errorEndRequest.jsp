<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title>Erro</title>
		<link rel="stylesheet" type="text/css" href="style2.css">
	</head>
	<body>
	<div align="center">
		<h1>Sistema de Pedidos</h1>
		<div id="erroForm">Erro ao finalizar o pedido verifique e tente novamente!</div>
		<br>
		<html:form action="/loadProduct">
			<html:submit styleId="submitForm" value="Voltar"></html:submit>
		</html:form>
	</div>	
	</body>
</html:html>

