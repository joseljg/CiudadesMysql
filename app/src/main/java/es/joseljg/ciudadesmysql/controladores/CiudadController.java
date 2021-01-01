package es.joseljg.ciudadesmysql.controladores;

import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.tareas.TareaInsertarCiudad;
import es.joseljg.ciudadesmysql.tareas.TareaMostrarCiudades;

public class CiudadController {

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
    public static void InsertarCiudad(Ciudad c)
    {

    }
    //---------------------------------------------------------------------------


}
