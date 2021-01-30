package es.joseljg.ciudadesmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.joseljg.ciudadesmysql.clases.Ciudad;
import es.joseljg.ciudadesmysql.clases.CiudadViewHolder;

public class MostrarDetalleCiudadActivity extends AppCompatActivity {
    TextView txt_detalle_nombrec = null;
    TextView txt_detalle_habitantes = null;
    TextView txt_detalle_idprovincia = null;
    ImageView img_detalle_ciudad= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_detalle_ciudad);
        txt_detalle_nombrec = findViewById(R.id.txt_detalle_nombrec);
        txt_detalle_habitantes = findViewById(R.id.txt_detalle_habitantes);
        txt_detalle_idprovincia = findViewById(R.id.txt_detalle_idprovincia);
        img_detalle_ciudad = findViewById(R.id.img_detalle_ciudad);
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