<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html>
<head>
<title>Register</title>
</head>
<body>
	<html:form action="/register">
		Name<html:text property="name" name="registerForm"></html:text>
		Fone<html:text property="fone" name="registerForm"></html:text>
		<html:submit value="Okay"/>
	</html:form>
</body>
</html>