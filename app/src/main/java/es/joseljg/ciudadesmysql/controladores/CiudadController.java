package es.joseljg.ciudadesmysql.controladores;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.tareas.TareaBorrarCiudad;
import es.joseljg.ciudadesmysql.tareas.TareaBorrarProvincia;
import es.joseljg.ciudadesmysql.tareas.TareaInsertarCiudad;
import es.joseljg.ciudadesmysql.tareas.TareaInsertarProvincia;
import es.joseljg.ciudadesmysql.tareas.TareaMostrarCiudades;
import es.joseljg.ciudadesmysql.tareas.TareaObtenerCiudades;

public class CiudadController {

    public static ArrayList<Ciudad> obtenerCiudades()
    {
        ArrayList<Ciudad> ciudadesDevueltas = null;
        FutureTask t = new FutureTask (new TareaObtenerCiudades());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            ciudadesDevueltas= (ArrayList<Ciudad>)t.get();
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
        return ciudadesDevueltas;
    }
    //---------------------------------------------------------------------------
    //-----------------------------------------------------------------------------
    public static void MostrarCiudades(TextView txt_ciudades)
    {
        FutureTask t = new FutureTask (new TareaMostrarCiudades());
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t);
        try {
            ArrayList<Ciudad> ciudadesDevueltas= (ArrayList<Ciudad>)t.get();
            es.shutdown();
            try {
                if (!es.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                    es.shutdownNow();
                }
            } catch (InterruptedException e) {
                es.shutdownNow();
            }
            String texto_ciudades ="CIUDADES \n";
            if(ciudadesDevueltas != null) {
                for (Ciudad c : ciudadesDevueltas) {
                    texto_ciudades += c.toString() + "\n";
                }
                txt_ciudades.setText(texto_ciudades);
            }
            else {
                txt_ciudades.setText("no se recuperaron las ciudades");
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //---------------------------------------------------------------------------
    public static boolean InsertarCiudad(Ciudad c)
    {
        FutureTask t = new FutureTask(new TareaInsertarCiudad(c));
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

    public static boolean borrarCiudad(Ciudad cseleccionada) {
        FutureTask t = new FutureTask(new TareaBorrarCiudad(cseleccionada));
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
    //---------------------------------------------------------------------------


}
