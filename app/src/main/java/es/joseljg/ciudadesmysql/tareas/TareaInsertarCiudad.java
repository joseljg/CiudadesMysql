package es.joseljg.ciudadesmysql.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.modelos.CiudadDB;

public class TareaInsertarCiudad implements Callable<Boolean> {
    private Ciudad c = null;

    public TareaInsertarCiudad(Ciudad c) {
        this.c = c;
    }

    @Override
    public Boolean call() throws Exception {
        boolean insertadoOK = CiudadDB.insertarCiudadTabla(c);
        return insertadoOK;
    }
}
