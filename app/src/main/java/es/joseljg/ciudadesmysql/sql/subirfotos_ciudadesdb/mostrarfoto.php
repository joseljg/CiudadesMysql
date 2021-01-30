<?php

$imagen;

// Conexión con la base de datos.
$conn = new mysqli($_POST['host'], $_POST['usuario'], $_POST['clave'], $_POST['DB']);
 
// Check connection
if($conn === false){
    die("no pude conectarme a la base de datos " . $conn->connect_error . "<br>");
}
else{
// Print host information
echo "conexion establecida con " . $conn->host_info . "<br>";
if(isset($_POST["mostrarfoto"]))
{
    $stmt = $conn->prepare("SELECT foto FROM fotos_ciudades WHERE idciudad = ?");
    $stmt->bind_param("i", $_POST['valorPK']);
    $stmt->execute();
    $result = $stmt->get_result();
if($result->num_rows > 0){
    $data = $result->fetch_assoc();  
    $imagen = $data['foto'];
    echo '<img src="data:image/jpeg;base64,'.base64_encode($imagen) .'" />';
}else{
    echo 'Imagen no encontrada...';
}
}
$stmt->close();
$conn->close();
}
?>

