<?php
header("Content-Type: application/json; charset=UTF-8");
include('conexion.php');

if($_SERVER["REQUEST_METHOD"] == 'POST'){
	$id = $_POST['idP'];
	$sql = "SELECT * FROM productos WHERE id = ".$id;
	$result = mysqli_query($conexion,$sql);
	$response = array();

	while($row = mysqli_fetch_assoc($result)){
		array_push($response, array(
			'id' => $row['id'],
			'nombre' => $row['nombre'],
			'precio' => $row['precio'],
		));
	}
}
echo json_encode($response);
mysqli_close($conexion);

?>