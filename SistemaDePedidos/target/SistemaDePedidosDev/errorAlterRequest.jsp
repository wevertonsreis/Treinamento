<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title><bean:message key="error"/></title>
		<link rel="stylesheet" type="text/css" href="style2.css">
	</head>
	<body>
	<div align="center">
		<h1><bean:message key="label.system.request"/></h1>
		<div id="erroForm">
			<bean:message key="error.alter.request"/>
		</div>
		<br>
		<html:form action="loadRequest" >
			<html:submit styleId="submitForm" value="Meus Pedidos"/>
		</html:form>
	</div>
	</body>
</html:html>