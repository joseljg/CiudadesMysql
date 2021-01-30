package es.joseljg.ciudadesmysql.tareas;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import es.joseljg.ciudadesmysql.clases.FotoCiudad;
import es.joseljg.ciudadesmysql.modelos.CiudadDB;

public class TareaObtenerFotosCiudades implements Callable<ArrayList<FotoCiudad>> {

    private int width;
    private int height;

    public TareaObtenerFotosCiudades(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public ArrayList<FotoCiudad> call() throws Exception {
        ArrayList<FotoCiudad> fotosCiudades = CiudadDB.obtenerFotosCiudades(this.width, this.height);
        return fotosCiudades;
    }
}