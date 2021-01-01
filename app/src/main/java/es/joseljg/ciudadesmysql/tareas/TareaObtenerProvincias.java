package es.joseljg.ciudadesmysql.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.modelos.CiudadDB;
import es.joseljg.ciudadesmysql.modelos.ProvinciaDB;

public class TareaObtenerProvincias implements Callable<ArrayList<Provincia>> {
    @Override
    public ArrayList<Provincia> call() throws Exception {
        ArrayList<Provincia> provincias = ProvinciaDB.obtenerProvincias();
        return provincias;
    }
}
