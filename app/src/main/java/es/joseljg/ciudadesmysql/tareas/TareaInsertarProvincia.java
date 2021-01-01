package es.joseljg.ciudadesmysql.tareas;

import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.modelos.CiudadDB;
import es.joseljg.ciudadesmysql.modelos.ProvinciaDB;

public class TareaInsertarProvincia implements Callable<Boolean> {
    private Provincia p = null;

    public TareaInsertarProvincia(Provincia p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        boolean insertadoOK = ProvinciaDB.insertarProvinciaTabla(p);
        return insertadoOK;
    }
}
