<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title><bean:message key="label.my.request"/></title>
		<link rel="stylesheet" type="text/css" href="style2.css">
	</head>
	<body>
	<div align="center">
		<h1><bean:message key="label.my.request"/></h1>
		<html:form action="/newRequest">
			<html:submit styleId="submitForm" value="Novo Pedido"/>
		</html:form>
		<table>
			<tr>
				<th><bean:message key="label.number"/></th>
				<th><bean:message key="label.cnpj"/></th>
				<th><bean:message key="label.cnpj.client"/></th>
				<th><bean:message key="label.status.request"/></th>
				<th><bean:message key="label.creator"/></th>
				<th><bean:message key="label.date.criation"/></th>
				<th><bean:message key="label.date.emission"/></th>
				<th><bean:message key="label.alter"/></th>
				<th><bean:message key="label.remove"/></th>
			</tr>
			<logic:iterate id="loadRequest" name="addProductForm" property="listRequest">
			<tr>
				<td>
					<bean:write name="loadRequest" property="id"/>
				</td>
				<td>
					<bean:write name="loadRequest" property="cnpj"/>
				</td>
				<td>
					<bean:write name="loadRequest" property="cnpjClient"/>
				</td>	
				<td>
					<bean:write name="loadRequest" property="status"/>
				</td>
				<td>
					<bean:write name="loadRequest" property="creator"/>
				</td>
				<td>
					<bean:write name="loadRequest" property="creationDate" format="dd/MM/yyyy"/>
				</td>
				<td>
					<bean:write name="loadRequest" property="emissionDate" format="dd/MM/yyyy"/>
				</td>
				<td>
					<html:link action="/alterRequest" paramId="id" paramName="loadRequest" paramProperty="id" >
						<html:image  src="images/edit.png" />
					</html:link>
				</td>
				<td>
					<html:link action="/removeRequest" paramId="id" paramName="loadRequest" paramProperty="id" >
						<html:image  src="images/delete.png" />
					</html:link>
				</td>
			</tr>
			</logic:iterate>
		</table>
	</div>	
	</body>
</html:html>