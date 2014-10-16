<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<title>Busqueda de Socios</title>
		<script type="text/javascript" src="../js/jquery.js"></script>
		<script type="text/javascript" src="../js/sumarFunciones.js"></script>
		<script type="text/javascript" src="../js/autoNumeric.js"></script>
	</head>
 
	<body>
		<div id="busqueda">
			<span>Ingrese el DNI del socio:</span>
			<input type="text" id="dni" maxlength="8" size="30px;" />
			<input type="button" id="buscarDNI" value="Buscar" />
		</div>
		 
		<div id="mensajes" style="background-color: red; color: yellow;"></div>

		<div id="socio" class="socioClass">
		 	<span>Socio: </span>
		 	<span id="nombreCompleto"></span>
		 	<br>
		 	<span>D.N.I.: </span>
		 	<span id="dniBuscado"></span>
		 	<br>
		 	<span>Ingrese monto facturado: </span>
		 	<input type="text" id="monto" maxlength="8" size="30px;" />
		 	<input type="button" id="cargarMonto" value="OK" />
		</div>
		<!--br>
		<br>
		<br>
		<br>
		<div>
			<img src="img/cargando.gif">
		</div-->
	</body>
</html>