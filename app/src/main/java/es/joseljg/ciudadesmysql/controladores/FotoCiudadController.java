package es.joseljg.ciudadesmysql.controladores;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.ciudadesmysql.clases.FotoCiudad;
import es.joseljg.ciudadesmysql.tareas.TareaObtenerFotosCiudades;

public class FotoCiudadController {

    public static ArrayList<FotoCiudad> obtenerFotosCiudades() {

        ArrayList<FotoCiudad> fotosCiudades = null;
        FutureTask t = new FutureTask (new TareaObtenerFotosCiudades(100,100));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
           fotosCiudades= (ArrayList<FotoCiudad>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fotosCiudades;
    }
}
