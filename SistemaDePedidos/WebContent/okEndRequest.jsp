<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title><bean:message key="label.system.request"/></title>
		<link rel="stylesheet" type="text/css" href="style2.css">
	</head>
	<body>
	<div align="center">
		<h1><bean:message key="label.system.request"/></h1>
		<div id="okForm">Pedido finalizado com sucesso!</div>
		<br>
		<!-- Action for go back request page -->
		<html:form action="loadRequest" >
			<html:submit styleId="submitForm" value="Meus Pedidos"/>
		</html:form>
		<!-- Action for creation of new request -->
		<html:form action="newRequest">
			<html:submit styleId="submitForm" value="Novo Pedido"/>
		</html:form>
	</div>	
	</body>
</html:html>