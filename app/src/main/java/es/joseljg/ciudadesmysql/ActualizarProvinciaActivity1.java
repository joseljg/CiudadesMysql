package es.joseljg.ciudadesmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.controladores.ProvinciaController;

public class ActualizarProvinciaActivity1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_PROVINCIA = "es.joseljg.ActualizarProvinciaActivity1.provincia";
    Spinner sp_actualizarp = null;
    static Provincia pseleccionada = null;
    static ArrayAdapter<Provincia> adapter = null;
    ArrayList<Provincia> provincias = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_provincia1);
        sp_actualizarp = (Spinner) findViewById(R.id.sp_actualizarp);
        if(sp_actualizarp != null) {
            sp_actualizarp.setOnItemSelectedListener(this);
            provincias = ProvinciaController.obtenerProvincias();
            if(provincias != null) {
                adapter = new ArrayAdapter<Provincia>(this, R.layout.item_provincia, provincias);
                sp_actualizarp.setAdapter(adapter);
            }
        }
    }

    public void siguienteactualizarProvincia(View view) {
        Intent intent = new Intent(this, ActualizarProvinciaActivity2.class);
        intent.putExtra(EXTRA_OBJETO_PROVINCIA, pseleccionada);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Provincia p = (Provincia) sp_actualizarp.getItemAtPosition(position);
        pseleccionada = p;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}