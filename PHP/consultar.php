<?php
header("Content-Type: application/json; charset=UTF-8");
include('conexion.php');

$sql = "SELECT * FROM mascota";
$result = mysqli_query($conexion,$sql);
$response = array();

while($row = mysqli_fetch_assoc($result)){
	array_push($response, array(
		'id' => $row['m_id'],
		'nombre' => $row['m_nombre'],
		'tipo' => $row['m_tipo'],
		'edad' => $row['m_edad']
	));
}
echo json_encode($response);
mysqli_close($conexion);

?>