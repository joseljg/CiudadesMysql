package es.joseljg.ciudadesmysql.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.modelos.CiudadDB;

public class TareaObtenerCiudades implements Callable<ArrayList<Ciudad>> {
    @Override
    public ArrayList<Ciudad> call() throws Exception {
        ArrayList<Ciudad> ciudades = CiudadDB.obtenerCiudades();
        return ciudades;
    }
}
