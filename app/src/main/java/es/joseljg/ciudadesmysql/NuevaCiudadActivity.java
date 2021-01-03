package es.joseljg.ciudadesmysql;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.Provincia;
import es.joseljg.ciudadesmysql.controladores.CiudadController;
import es.joseljg.ciudadesmysql.controladores.ProvinciaController;

public class NuevaCiudadActivity extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    public static final String EXTRA_OBJETO_CIUDAD = "es.joseljg.NuevaCiudadActivity.ciudad";
    Spinner sp_nuevac_provincia = null;
    Provincia pseleccionada = null;
    ArrayAdapter<Provincia> adapter = null;
    ArrayList<Provincia> provincias = null;
    EditText edt_nuevac_nombre = null;
    EditText edt_nuevac_habitantes = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_ciudad);
        edt_nuevac_nombre = findViewById(R.id.edt_nuevac_nombre);
        edt_nuevac_habitantes = findViewById(R.id.edt_nuevac_habitantes);
        sp_nuevac_provincia = (Spinner) findViewById(R.id.sp_nuevac_provincia);
        if(sp_nuevac_provincia != null) {
            sp_nuevac_provincia.setOnItemSelectedListener(this);
            provincias = ProvinciaController.obtenerProvincias();
            if(provincias != null) {
                adapter = new ArrayAdapter<Provincia>(this, R.layout.item_provincia, provincias);
                sp_nuevac_provincia.setAdapter(adapter);
            }
        }
    }
    public void mostrarToast(String mensaje)
    {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void insertarCiudad(View view) {
        AlertDialog.Builder alerta1 = new AlertDialog.Builder(this);
        alerta1.setTitle("quieres guardar la ciudad?");
        //alerta1.setMessage(" no -> cancelar, si-> guardar");
        alerta1.setPositiveButton("si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(pseleccionada == null)
                {
                    mostrarToast("selecciona una provincia");
                    return;
                }
                Ciudad c = null;
                try{
                    String nombre = String.valueOf(edt_nuevac_nombre.getText());
                    int habitantes = Integer.valueOf(String.valueOf(edt_nuevac_habitantes.getText()));
                    c = new Ciudad(nombre, habitantes, pseleccionada.getIdprovincia());

                }catch (Exception e)
                {
                    mostrarToast("error, revisa los datos introducidos");
                }
                //insertar Ciudad
                boolean insertadoOK = CiudadController.InsertarCiudad(c);
                if(insertadoOK)
                {
                    mostrarToast("ciudad insertada correctamente");
                    Intent intent = new Intent();
                    intent.putExtra(EXTRA_OBJETO_CIUDAD, c);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    mostrarToast("no se pudo crear la ciudad");
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
        Provincia p = (Provincia) sp_nuevac_provincia.getItemAtPosition(position);
        pseleccionada = p;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}