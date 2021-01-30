package es.joseljg.ciudadesmysql.modelos;
import android.graphics.Bitmap;
import android.util.Log;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.FotoCiudad;
import es.joseljg.ciudadesmysql.utilidades.ImagenesBlobBitmap;


public class CiudadDB {


    //-----------------------------------------------------------
    public static ArrayList<Ciudad> obtenerCiudades() {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        ArrayList<Ciudad> ciudadesDevueltas = new ArrayList<Ciudad>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from ciudades";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                int idciudad = resultado.getInt("idciudad");
                String nombre = resultado.getString("nombre");
                int habitantes = resultado.getInt("habitantes");
                int idprovincia = resultado.getInt("idprovincia");
                Ciudad c = new Ciudad(idciudad, nombre, habitantes, idprovincia);
                ciudadesDevueltas.add(c);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return ciudadesDevueltas;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }
    }

    //-------------------------------------------------------
    public static boolean insertarCiudadTabla(Ciudad c) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "INSERT INTO ciudades (nombre, habitantes,idprovincia) VALUES (?, ?, ?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, c.getNombre());
            pst.setInt(2, c.getHabitantes());
            pst.setInt(3, c.getIdprovincia());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //-----------------------------------------------------------
    public static boolean borrarCiudadTabla(Ciudad c) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "DELETE FROM ciudades WHERE idciudad = ?;";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setInt(1, c.getIdciudad());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //---------------------------------------------------------------
    public static boolean actualizarCiudadTabla(Ciudad c) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return false;
        }
        //----------------------------
        try {
            String ordensql = "UPDATE ciudades SET nombre = ?, habitantes = ?, idprovincia = ? WHERE (idciudad = ?);";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, c.getNombre());
            pst.setInt(2, c.getHabitantes());
            pst.setInt(3, c.getIdprovincia());
            pst.setInt(4, c.getIdciudad());
            int filasAfectadas = pst.executeUpdate();
            pst.close();
            conexion.close();
            if (filasAfectadas > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    //--------------------------------------------------------------
    public static Ciudad buscarCiudadTabla(String nombre) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        //---------------------------------
        Ciudad ciudadEncontrada = null;
        try {
            String ordensql = "select * from ciudades where nombre like ?";
            PreparedStatement pst = conexion.prepareStatement(ordensql);
            pst.setString(1, nombre);
            ResultSet resultadosql = pst.executeQuery();
            //------------------------------------------------
            while (resultadosql.next()) {
                int idciudad = resultadosql.getInt("idciudad");
                String nombreciudad = resultadosql.getString("nombre");
                int habitantes = resultadosql.getInt("habitantes");
                int idprovincia = resultadosql.getInt("idprovincia");
                ciudadEncontrada = new Ciudad(idciudad, nombreciudad, habitantes, idprovincia);
            }
            resultadosql.close();
            pst.close();
            conexion.close();
            return ciudadEncontrada;
        } catch (SQLException e) {
            return null;
        }
    }

    public static ArrayList<FotoCiudad> obtenerFotosCiudades(int width, int height) {
        Connection conexion = BaseDB.conectarConBaseDeDatos();
        if (conexion == null) {
            return null;
        }
        ArrayList<FotoCiudad> fotosCiudadesDevueltas = new ArrayList<FotoCiudad>();
        try {
            Statement sentencia = conexion.createStatement();
            String ordenSQL = "select * from fotos_ciudades";
            ResultSet resultado = sentencia.executeQuery(ordenSQL);
            while (resultado.next()) {
                int idfoto = resultado.getInt("idfoto");
                Blob foto = resultado.getBlob("foto");
                Bitmap bm_foto = ImagenesBlobBitmap.blob_to_bitmap(foto, width, height);
                int idciudad = resultado.getInt("idciudad");
                FotoCiudad fc = new FotoCiudad(idfoto, bm_foto, idciudad);
                fotosCiudadesDevueltas.add(fc);
            }
            resultado.close();
            sentencia.close();
            conexion.close();
            return fotosCiudadesDevueltas;
        } catch (SQLException e) {
            Log.i("sql", "error sql");
            return null;
        }
    }
}
//--------------------------------------------------------------