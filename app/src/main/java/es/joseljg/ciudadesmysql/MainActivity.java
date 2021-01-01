package es.joseljg.ciudadesmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import es.joseljg.ciudadesmysql.controladores.CiudadController;

public class MainActivity extends AppCompatActivity {

    private TextView txt_ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_ciudades = (TextView) findViewById(R.id.txt_ciudades);
    }

    public void mostrarCiudades(View view) {
        CiudadController.MostrarCiudades(txt_ciudades);
    }
}