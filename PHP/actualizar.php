<?php
header("Content-Type: application/json; charset=UTF-8");
include('conexion.php');

$response = array();

if($_SERVER["REQUEST_METHOD"] == 'POST'){
	$id = $_POST['idM'];
	$nombre = $_POST['nombreM'];
	$tipo = $_POST['tipoM'];
	$edad = $_POST['edadM'];
	
	$sql = "UPDATE mascota SET m_nombre = ?, m_tipo = ?, m_edad = ? WHERE m_id = ?";
	
	if($query = $conexion -> prepare($sql)){
		$query -> bind_Param('ssii', $nombre, $tipo, $edad, $id);
		$result = $query -> execute();
	}else{
		array_push($response, array('message' => '1. Error en la consulta'));
	}
	
	if($result){
		array_push($response, array('message' => 'Se acualizo satisfactoriamente'));
	}else{
		array_push($response, array('message' => '2. Error en la BD'));
	}
	mysqli_close($conexion);
}else{
	array_push($response, array('message' => '3. Error de conexion'));
}
echo json_encode($response);
?>