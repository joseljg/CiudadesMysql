package es.joseljg.ciudadesmysql.controladores;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.tareas.TareaActualizarProvincia;
import es.joseljg.ciudadesmysql.tareas.TareaBorrarProvincia;
import es.joseljg.ciudadesmysql.tareas.TareaInsertarProvincia;
import es.joseljg.ciudadesmysql.tareas.TareaMostrarCiudades;
import es.joseljg.ciudadesmysql.tareas.TareaObtenerProvincias;

public class ProvinciaController {

    public static boolean insertarProvincia(Provincia p) {
        FutureTask t = new FutureTask(new TareaInsertarProvincia(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean insercionOK = false;
        try {
            insercionOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return insercionOK;
        }
    }

    //---------------------------------------------------------------------------

    public static ArrayList<Provincia>   obtenerProvincias()
    {
        ArrayList<Provincia> provinciasDevueltas = null;
        FutureTask t = new FutureTask (new TareaObtenerProvincias());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            provinciasDevueltas= (ArrayList<Provincia>)t.get();
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
        return provinciasDevueltas;
    }
    //---------------------------------------------------------------------------
    public static boolean   borrarProvincia(Provincia p) {
        FutureTask t = new FutureTask(new TareaBorrarProvincia(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean borradoOK = false;
        try {
            borradoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return borradoOK;
        }
    }

    public static boolean actualizarProvincia(Provincia p) {
        FutureTask t = new FutureTask(new TareaActualizarProvincia(p));
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        boolean actualizadoOK = false;
        try {
            actualizadoOK = (boolean) t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            return actualizadoOK;
        }
    }
}
