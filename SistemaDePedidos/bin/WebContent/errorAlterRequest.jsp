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
		<div id="erroForm">Não se pode alterar um pedido já aprovado!</div>
		<br>
		<html:form action="loadRequest" >
			<html:submit styleId="submitForm" value="Meus Pedidos"/>
		</html:form>
	</div>	
	</body>
</html:html>
