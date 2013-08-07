<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
<head>
<title>Register</title>
</head>
<body>
	<script type="text/javascript">
		function save(){
			document.forms[0].action = "register.do?method=save"
			document.forms[0].submit();
		}
		
		function del() {
			document.forms[0].action = "register.do?method=remove"
			document.forms[0].submit();
		}
	</script>

	</head>

	<html:form action="/register">
		Name<html:text property="name" name="registerForm"/>
		<br>
		Fone<html:text property="fone" name="registerForm"/>
		<br>
		<html:submit value="Save" onclick="save()"/>
		<html:submit value="Remove" onclick="del()"/>
	</html:form>
	
</body>
</html>