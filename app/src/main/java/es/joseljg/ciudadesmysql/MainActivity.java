package es.joseljg.ciudadesmysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import es.joseljg.ciudadesmysql.controladores.CiudadController;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nuevaProvincia(View view) {
        Intent intent = new Intent(this, NuevaProvinciaActivity.class);
        startActivity(intent);
    }

    public void borrarProvincia(View view) {
        Intent intent = new Intent(this, BorrarProvinciaActivity.class);
        startActivity(intent);
    }

    public void actualizarProvincia(View view) {
        Intent intent = new Intent(this, ActualizarProvinciaActivity1.class);
        startActivity(intent);
    }

    public void mostrarCiudad(View view) {
        Intent intent = new Intent(this, MostrarCiudadesActivity.class);
        startActivity(intent);
    }
}