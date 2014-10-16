/**
 * Inicializo los eventos posibles
 */
$(document).ready(function () {
	$("#socio").hide();
	$("#mensajes").hide();
	$("#buscarDNI").focus().keypress(isEnter).click(buscarPorDni);
	$("#cargarMonto").click(ingresarMonto);
	$("#dni").keyup(function () {
		$("#dni").autoNumeric('init', {aSep: '.', aDec: ',', mDec: '0' , vMax: '99999999'});
	});
	$("#monto").keyup(function () {
		this.value = this.value.replace(/\./g, ',').replace(/[^0-9]/g,'');
		//$("#monto").autoNumeric('init', {aSep: '.', aDec: ',', vMax: '99999.99'});
	});
});

/**
 * Ejecuto la busqueda por DNI
 */
function buscarPorDni() {
	// Escondo si quedo algun msj anterior
	$("#mensajes").hide();
	// Cargo el DNI de pantalla
	var dni = $("#dni").val();

	// Controlo si ingreso algun DNI
	if (dni != null && dni != "") {
		// Le saco los puntos
		dni = dni.replace(/\./g, "");

		$.ajax({
		       type: "POST",
		       url:"busqueda.action",
		       data : {"dni" : dni},
	           dataType : "json",
	           beforeSend:inicioEnvio,
	           success: cargarCliente,
		       error: errorAjax,
		       //, timeout:4000
		       });
	} else {
		$("#mensajes").text("Por favor, ingrese un numero de D.N.I.");
		$("#mensajes").show("slow");
		$("#dni").focus();
	}

	return false;
}

/**
 * Cargo los valores del cliente
 */
function cargarCliente(jsonResponse) {
	// Valido si encontre al usuario
	if (jsonResponse.nombreCompleto != null) {
		$("#socio").show("slow");
		$("#dni").val("");
		$("#nombreCompleto").text(jsonResponse.nombreCompleto);
		$("#dniBuscado").text(jsonResponse.dni);
		$("#dniBuscado").autoNumeric('init', {aSep: '.', aDec: ',', mDec: '0' , vMax: '99999999'});
		$("#monto").focus();
	} else {
		$("#mensajes").text("Socio con D.N.I.: " +  jsonResponse.dni + ". No encontrado");
		$("#mensajes").show("slow");
	}
}

/**
 * Mensaje, en caso de error con la llamada a ajax
 */
function errorAjax() {
	alert("Problema en el servidor");
}

/**
 * Si preciono "enter" es como hacer click
 */
function isEnter(e) {
	alert("e:" + e);
    if(e.which == 13) {
    	
    	alert("buscarPorDni:");
    	
    	buscarPorDni();
    }
}

/**
 * Cosas a hacer antes de recargar la pagina
 */
function inicioEnvio() {
	$("#socio").hide();
	$("#buscarDNI").focus();
	$("#mensajes").hide();
}

/**
 * Actualizo el monto del usuario
 */
function ingresarMonto() {
	
	var dni = $("#dniBuscado").text();
	dni = dni.replace(/\./g, "");
	var monto = $("#monto").val();	

	$.ajax({
       type: "POST",
       url:"sumarPuntos.action",
       data : {"dni" : dni,
    	   	   "monto" : monto},
       dataType : "json",
       success: ingresoMonto,
       error: errorAjax
       //,timeout:4000
	});
}


function ingresoMonto(jsonResponse) {
	alert("Cantitad de puntos actual: " + jsonResponse.puntos);
}

/*
Rotar una imagen 
transition: all 0.7s;
transform: rotate(6.28rad);
*/


//this.value = this.value.replace(/[^0-9]/g,'');
