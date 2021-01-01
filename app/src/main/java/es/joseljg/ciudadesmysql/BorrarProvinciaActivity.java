package es.joseljg.ciudadesmysql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.controladores.ProvinciaController;

public class BorrarProvinciaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner sp_borrarp = null;
    Provincia pseleccionada = null;
    ArrayAdapter<Provincia> adapter = null;
    ArrayList<Provincia> provincias = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_provincia);
        sp_borrarp = (Spinner) findViewById(R.id.sp_borrarp);
        if(sp_borrarp != null) {
            sp_borrarp.setOnItemSelectedListener(this);
            provincias = ProvinciaController.obtenerProvincias();
            if(provincias != null) {
                adapter = new ArrayAdapter<Provincia>(this, R.layout.item_provincia, provincias);
                sp_borrarp.setAdapter(adapter);
            }
        }
    }

    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void borrarProvincia(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("borrar la provincia?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(pseleccionada == null)
                {
                    mostrarToast("selecciona una provincia");
                    return;
                }
                //borrar provincia
                boolean borradoOK = ProvinciaController.borrarProvincia(pseleccionada);
                // recargar combo (o desde la base de datos volver a solicitar todo, o quitar solamente el item borrado)
                if(borradoOK)
                {
                    mostrarToast("provincia borrada correctamente");
                    // opcion 1, leemos todas las provincias de la base de datos otra vez
                    adapter.clear();
                    provincias = ProvinciaController.obtenerProvincias();
                    adapter.addAll(provincias);
                    //  adapter.add(new Provincia("provincia3"));
                    // opcion 2, borramos del adaptador la provincia borrada
                    //  adapter.remove(pseleccionada);
                }
                else{
                    mostrarToast("la provincia no se pudo borrar");
                }
            }
        });
        alerta1.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alerta1.show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Provincia p = (Provincia) sp_borrarp.getItemAtPosition(position);
        pseleccionada = p;
       //  Toast.makeText(this, p.getNombre(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}