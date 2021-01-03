package es.joseljg.ciudadesmysql.tareas;

import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.modelos.CiudadDB;
import es.joseljg.ciudadesmysql.modelos.ProvinciaDB;

public class TareaBorrarCiudad implements Callable<Boolean> {
    private Ciudad c = null;

    public TareaBorrarCiudad(Ciudad c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        boolean borradoOK = CiudadDB.borrarCiudadTabla(c);
        return borradoOK;
    }
}
