package es.joseljg.ciudadesmysql.tareas;

import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.modelos.ProvinciaDB;

public class TareaBorrarProvincia implements Callable<Boolean> {
    private Provincia p = null;

    public TareaBorrarProvincia(Provincia p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        boolean insertadoOK = ProvinciaDB.borrarProvinciaTabla(p);
        return insertadoOK;
    }
}
