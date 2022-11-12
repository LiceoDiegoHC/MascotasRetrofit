<?php
//Instruccion para recibir o crear unapp Json
header("Content-Type: application/json; charset=UTF-8");
include('conexion.php');

$response = array();

if($_SERVER["REQUEST_METHOD"] == "POST"){
	$nombre = $_POST['nombre'];
	$tipo = $_POST['tipo'];
	$edad = $_POST['edad'];
	
	if($query = $conexion -> prepare("INSERT INTO mascota(m_nombre, m_tipo, m_edad) VALUES(?,?,?)")){
		$query -> bind_Param('ssi', $nombre, $tipo, $edad);
		$result = $query -> execute();
	}else{
		array_push($response, array('message' => '2. No se realizo la insercion'));
	}
	
	if($result){
		array_push($response, array('message' => '0. Registrado corrctamente'));
	}else{
		array_push($response, array('message' => '1. Error de insercion'));
	}
	mysqli_close($conexion);
}else{
	array_push($response, array('message' => '3. No se puede acceder al servidor'));
}
echo json_encode($response);
?>