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
		<!-- Form for add items of request -->
		<html:form styleId="addProductForm" action="/addProduct">
					<h4><bean:message key="label.add.product"/></h4>
					<div id="erroForm"> 
						<html:errors/>
					</div>
					
					<bean:message key="label.cnpj"/><html:text property="cnpj" name="addProductForm"/>
					<bean:message key="label.quantity"/><html:text property="quantity" name="addProductForm"/> 
				
					<bean:message key="label.product"/>
					<html:select property="id">
							<html:option value="0"><bean:message key="label.select.product"/></html:option>
							<html:optionsCollection property="listProducts" label="description" value="id"/>
					</html:select>
						
					<html:submit styleId="submitForm" value="Adicionar Produto"/> 
		</html:form>
		<br>
		<!-- Listing the items of request -->
		<table>
			<tr>
				<th><bean:message key="label.product"/></th>
				<th><bean:message key="label.quantity"/></th>
				<th><bean:message key="label.unitary.value"/></th>
				<th><bean:message key="label.product.value"/></th>
				<th><bean:message key="label.remove"/></th>
			</tr>
			<logic:iterate id="itemRequest" name="addProductForm" property="listItems">
			<tr>
				<td>
					<bean:write name="itemRequest" property="product.description"/>
				</td>
				<td>
					<bean:write name="itemRequest" property="quantity"/>
				</td>	
				<td>
					<bean:write name="itemRequest" property="product.unitaryValue" format="R$#,###.00"/>
				</td>
				<td>
					 <bean:write name="itemRequest" property="valueProducts" format="R$#,###.00"/>
				</td>
				<td>	
					<!-- Action for remove item of request -->
					<html:link action="/removeItem" paramId="id" paramName="itemRequest" paramProperty="id" >
						<html:image  src="images/delete.png" />
					</html:link> 
				</td>
			</tr>
			</logic:iterate>
			<tr>
				<td colspan="3"></td>
				<td> <bean:message key="label.total"/> </td>
				<td><bean:write name="addProductForm" property="total"  format="R$#,##0.00"/></td>	
			</tr>			
		</table>
		<!-- Action for ending request -->
		<html:form action="/endRequest">
			<html:submit styleId="submitForm" value="Finalizar Pedido"/>	
		</html:form>	
		<!-- Action for save request and leaving open -->	
		<html:form action="saveRequest">
			<html:submit styleId="submitForm" value="Meus Pedidos"/>
		</html:form>
	</div>	
	</body>
</html:html>