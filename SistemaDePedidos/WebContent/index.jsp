<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html>
	<head>
		<title>Sistema de Pedidos</title>
		<link rel="stylesheet" type="text/css" href="style2.css">
	</head>
	<body>
	<div align="center">
		<h1>Sistema de Pedidos</h1>
		
		<html:form styleId="addProductForm" action="/addProduct">
			
					<h4>Adcionar Produto</h4>
					<div id="erroForm"> 
						<html:errors/>
					</div>
					
					CNPJ<html:text property="cnpj" name="addProductForm"/>
					Quantidade<html:text property="quantity" name="addProductForm"/> 
				
					Produto
					<html:select property="id">
							<html:option value="0">Selecione o Produto</html:option>
							<html:optionsCollection property="listProducts" label="description" value="id"/>
					</html:select>
						
					<html:submit styleId="submitForm" value="Adicionar Produto"/> 
			</html:form>
		
		
		<br>
		<table>
			<tr>
				<th>Produto</th>
				<th>Quantidade</th>
				<th>Valor unitário</th>
				<th>Valor dos produtos</th>
				<th>Excluir Item</th>
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
					<html:link action="/removeItem" paramId="id" paramName="itemRequest" paramProperty="id" >
						<html:image  src="images/delete.png" />
					</html:link> 
				</td>
			</tr>
			 </logic:iterate>
			<tr>
				<td colspan="3"></td>
				
				<td> Total</td>
				<td> <bean:write name="addProductForm" property="total"  format="R$#,##0.00"/> </td>
				
			</tr>
					
		</table>
		<html:form action="/endRequest">
			<html:submit styleId="submitForm" value="Finalizar Pedido"/>	
		</html:form>		
		<html:form action="saveRequest">
			<html:submit styleId="submitForm" value="Meus Pedidos"/>
		</html:form>
	</div>	
	</body>
</html:html>

