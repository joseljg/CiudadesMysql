package es.joseljg.ciudadesmysql.tareas;

import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.modelos.ProvinciaDB;

public class TareaActualizarProvincia implements Callable<Boolean> {
    private Provincia p = null;

    public TareaActualizarProvincia(Provincia p) {
        this.p = p;
    }

    @Override
    public Boolean call() throws Exception {
        boolean actualizadoOK = ProvinciaDB.actualizarProvinciaTabla(p);
        return actualizadoOK;
    }
}
