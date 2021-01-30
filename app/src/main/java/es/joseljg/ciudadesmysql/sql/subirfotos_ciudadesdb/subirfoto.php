<?php
// Conexión con la base de datos.
$conn = new mysqli($_POST['host'], $_POST['usuario'], $_POST['clave'], $_POST['DB']);
 
// Check connection
if($conn === false){
    die("no pude conectarme a la base de datos " . $conn->connect_error . "<br>");
}
 
// Print host information
echo "conexion establecida con " . $conn->host_info . "<br>";


if(isset($_POST["subir"]))
{
// Comprobamos si ha ocurrido un error.
if (( !isset($_FILES["foto"]) || $_FILES["foto"]["error"] > 0)){
echo "Ha ocurrido un error.";
} else { 
// Ahora vamos a verificar si el tipo de archivo es un tipo de imagen permitido.
// y que el tamano del archivo no exceda los 16MB
$permitidos = array("image/jpg", "image/jpeg", "image/gif", "image/png");
$limite_kb = 16384;
if (in_array($_FILES['foto']['type'], $permitidos) && $_FILES['foto']['size'] <= $limite_kb * 1024)
{
$imagen =  addslashes(file_get_contents($_FILES['foto']['tmp_name']));
$idciudad = $_POST['valorPK'];

/*
$stmt = $conn->prepare("INSERT INTO fotos_ciudades (foto, idciudad) VALUES (?,?)");
$stmt->bind_param("bi", $imagen, $idciudad);
$stmt->send_long_data(0, $imagen);
$stmt->execute();
*/
$query = "INSERT INTO fotos_ciudades (foto, idciudad) VALUES ( '$imagen', '$idciudad' )";  
$qry = mysqli_query($conn, $query);

}
else {
    echo "Archivo no permitido, es un tipo de archivo prohibido o excede el tamano de $limite_kb Kilobytes.";
}
}
}
// $stmt->close(); 
$conn->close();
?>