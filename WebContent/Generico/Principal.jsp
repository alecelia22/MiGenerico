<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Proyecto Generico</title>
	</head>
		<frameset cols="15%,*"> 
			<frame name="menu" id="menuId" src="<s:url value="Generico/Menu.jsp"/>">
			<frame name="principal" id="principalId" src="<s:url value="Generico/Inicio.jsp"/>">
		</frameset>
		
		<NOFRAMES>
			Debes actualizar tu navegador =S
		</NOFRAMES>
</html>