package es.joseljg.ciudadesmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import es.joseljg.ciudadesmysql.clases.Ciudad;

public class MostrarDetalleCiudadActivity extends AppCompatActivity {

    TextView txt_detalle_nombrec = null;
    TextView txt_detalle_habitantes = null;
    TextView txt_detalle_idprovincia = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalle_ciudad);
        txt_detalle_nombrec = findViewById(R.id.txt_detalle_nombrec);
        txt_detalle_habitantes = findViewById(R.id.txt_detalle_habitantes);
        txt_detalle_idprovincia = findViewById(R.id.txt_detalle_idprovincia);
        Intent intent = getIntent();
        if(intent != null)
        {
            Ciudad c = (Ciudad) intent.getSerializableExtra(NuevaCiudadActivity.EXTRA_OBJETO_CIUDAD);
            txt_detalle_nombrec.setText(c.getNombre());
            txt_detalle_habitantes.setText("habitantes: " + String.valueOf(c.getHabitantes()));
            txt_detalle_idprovincia.setText("idprovincia: " + String.valueOf(c.getIdprovincia()));
        }
    }
}