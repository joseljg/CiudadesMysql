package es.joseljg.ciudadesmysql.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDB {
	//----------------------------------------------------------....
	public static Connection conectarConBaseDeDatos() {
		try {
			Connection conexion = DriverManager.getConnection(ConfiguracionDB.URLMYSQL, ConfiguracionDB.USUARIODB, ConfiguracionDB.CLAVEDB);
			return conexion;
		} catch (SQLException e) {
			System.out.println("no se pudo establecer la conexion con la base de datos");
			return null;
		}		
	}	
	//-----------------------------------------------------------
	public static ResultSet obtenerDatosTabla(Connection conexion, String nombreTabla)
	{
		try {
			String ordensql = "select * from " + nombreTabla;
			Statement sentencia = conexion.createStatement();
			ResultSet resultado = sentencia.executeQuery(ordensql);
			return resultado;
		} catch (SQLException e) {
			return null;
		}
	}
	//-----------------------------------------------------------
	public static boolean borrarDatosTabla(Connection conexion, String tabla, String columna, String valorcolumna) {
		try {
			String ordensql= "delete from " + tabla +" where "+ columna + " like ? ";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1, valorcolumna);
			int filasafectadas = sentencia.executeUpdate();
			sentencia.close();
			conexion.close();
			if(filasafectadas >0 )
			{
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	//-----------------------------------------------------------------------------------
	public static ResultSet buscarFilasEnTabla(Connection conexion, String nombreTabla, String columna, String valorcolumna)
	{
		try {
			String ordensql = "select * from " + nombreTabla  + " where " + columna + " like ? ";
			PreparedStatement sentencia = conexion.prepareStatement(ordensql);
			sentencia.setString(1, valorcolumna);
			ResultSet resultado = sentencia.executeQuery();
			return resultado;
		} catch (SQLException e) {
			return null;
		}
	}
}
