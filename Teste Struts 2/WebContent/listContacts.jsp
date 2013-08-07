<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>List of Contacts</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>Fone</th>
		</tr>
		<logic:iterate id="contactList" name="registerForm" property="listContact">
			<tr>
				<th><bean:write name="contactList" property="name" /></th>
				<th><bean:write name="contactList" property="fone" /></th>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>