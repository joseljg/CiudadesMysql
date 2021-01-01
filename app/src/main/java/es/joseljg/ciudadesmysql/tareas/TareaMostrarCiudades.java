package es.joseljg.ciudadesmysql.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.modelos.CiudadDB;

public class TareaMostrarCiudades  implements Callable<ArrayList<Ciudad>> {
    private ArrayList<Ciudad> ciudades = null;
    @Override
    public ArrayList<Ciudad> call() throws Exception {
        ciudades = CiudadDB.obtenerCiudades();
        return ciudades;
    }
}
